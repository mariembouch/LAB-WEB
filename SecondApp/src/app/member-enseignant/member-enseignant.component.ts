import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Member } from 'src/models/member';
import { MemberService } from 'src/services/member.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Enseignant } from 'src/models/enseignant';
import { Etudiant } from 'src/models/etudiant';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AffecterEnseignantComponent } from '../affecter-enseignant/affecter-enseignant.component';
import { Router } from '@angular/router';
@Component({
  selector: 'app-member-enseignant',
  templateUrl: './member-enseignant.component.html',
  styleUrls: ['./member-enseignant.component.css']
})
export class MemberEnseignantComponent implements AfterViewInit, OnInit{
  enseignantSource: MatTableDataSource<Enseignant>; // db.tab.enseignants

  enseignantColumns: string[] = [ 'cin', 'nom','prenom','dateNaissance','cv', 'grade', 'etablissement', 'actions'];

  @ViewChild('enseignantPaginator') enseignantPaginator: MatPaginator;

  loadMembers() : void{
    // Enseignants
    this.MS.getEnseignants().subscribe(members => {
      this.enseignantSource = new MatTableDataSource(members);

      if (this.enseignantSource){
        console.log(this.enseignantSource.data);
        this.enseignantSource.paginator = this.enseignantPaginator; // Assign the paginator
      }

    });

  }

  constructor (private MS: MemberService,private dialog: MatDialog,  private router: Router){

  }

  ngOnInit(){
    this.loadMembers();
  }
  ngAfterViewInit() {

  }

  applyFilterOnEnseignants(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.enseignantSource.filter = filterValue.trim().toLowerCase();

    if (this.enseignantSource.paginator) {
      this.enseignantSource.paginator.firstPage();
    }
  }

  

  
  deleteEnseignant(memberId: number){
    this.MS.deleteEnseignant(memberId).subscribe(()=>{
      this.loadMembers();
    })
  }

 

}
