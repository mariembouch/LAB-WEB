import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Etudiant } from 'src/models/etudiant';
import { Member } from 'src/models/member';
import { MemberService } from 'src/services/member.service';
import { MyErrorStateMatcher } from '../app.module';
import { Enseignant } from 'src/models/enseignant';

@Component({
  selector: 'app-etudiant-form',
  templateUrl: './etudiant-form.component.html',
  styleUrls: ['./etudiant-form.component.css']
})
export class EtudiantFormComponent  implements OnInit {
  matcher = new MyErrorStateMatcher();
  form!: FormGroup;
  etudiantGlobal!: Member;
  // enseignants : Enseignant[] = [];
  idCourant1: number;
  constructor(private MS: MemberService, private router:Router, private activatedRoute: ActivatedRoute) { }

  initForm(): void{
    this.form = new FormGroup({
      cin: new FormControl(null, [Validators.required]),
      nom: new FormControl(null, [Validators.required]),
      prenom: new FormControl(null, [Validators.required]),
      dateNaissance: new FormControl(null, [Validators.required]),
      cv: new FormControl(null, [Validators.required]),
      
      dateInscription : new FormControl(null, [Validators.required]),
      diplome : new FormControl(null, []),
      sujet : new FormControl(null, []),
    })
  }

  initForm2(etudiant: Member): void{
    this.form = new FormGroup({
      cin: new FormControl(etudiant.cin, [Validators.required]),
      nom: new FormControl(etudiant.nom, [Validators.required]),
      prenom: new FormControl(etudiant.prenom, [Validators.required]),
      dateNaissance: new FormControl(etudiant.dateNaissance, [Validators.required]),
      cv: new FormControl(etudiant.cv, [Validators.required]),
      
      dateInscription : new FormControl(etudiant.dateInscription, [Validators.required]),
      diplome : new FormControl(etudiant.diplome, []),
      sujet : new FormControl(etudiant.sujet, []),

    })

  }
  ngOnInit():void{

    this.idCourant1 = this.activatedRoute.snapshot.params['id']; 
    console.log(this.idCourant1);
    if (!!this.idCourant1) 
    {
      this.MS.getMemberById(this.idCourant1).subscribe((etudiant)=>{
          this.etudiantGlobal = etudiant;
          this.initForm2(etudiant);
      });

    }else{ // je suis dans create
      this.initForm();
    }
  }

  OnSubmit():void{
    // récupérer le contenu
    console.log(this.form.value);

    var etudiant = {...this.etudiantGlobal, ...this.form.value};

    // this.form.value.cin 
//
    //
    // const etudiantNew = {...etudiant,
    //   //  id: etudiant.id ?? Math.ceil(Math.random()*1000),
    //     // createdDate: etudiant.createdDate ?? new Date().toISOString()
    // };
    if (!!this.idCourant1) // if truly idCourant  // je suis dans edit
    {
      etudiant = {id:this.idCourant1, ...etudiant};
      this.MS.updateMember("etudiant", etudiant).subscribe(()=> {this.router.navigate(['/members/etudiant/visit'])});
    }else{
      this.MS.saveMember("etudiant", etudiant).subscribe(()=> {this.router.navigate(['/members/etudiant/visit'])});
    }
    }
}
