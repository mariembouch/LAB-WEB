import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Etudiant } from 'src/models/etudiant';
import { Member } from 'src/models/member';
import { MemberService } from 'src/services/member.service';
import { AffecterEnseignantComponent } from '../affecter-enseignant/affecter-enseignant.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-member-etudiant',
  templateUrl: './member-etudiant.component.html',
  styleUrls: ['./member-etudiant.component.css']
})
export class MemberEtudiantComponent  implements AfterViewInit, OnInit{
  etudiantSource: MatTableDataSource<Etudiant>;
  etudiantColumns: string[] = [ 'cin', 'nom','prenom','dateNaissance','cv','encadrant','dateInscription','diplome','sujet', 'actions'];
  @ViewChild('etudiantPaginator') etudiantPaginator: MatPaginator;
loadMembers() : void{
    
    // Etudiants
    this.MS.getEtudiants().subscribe(members => {
      this.etudiantSource = new MatTableDataSource(members);
      if (this.etudiantSource){
        console.log(this.etudiantSource.data);
        this.etudiantSource.paginator = this.etudiantPaginator; // Assign the paginator
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

 

  applyFilterOnEtudiants(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.etudiantSource.filter = filterValue.trim().toLowerCase();

    if (this.etudiantSource.paginator) {
      this.etudiantSource.paginator.firstPage();
    }
  }

  affecter(etudiant: Member): void {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    const dialogRef = this.dialog.open(AffecterEnseignantComponent, dialogConfig);

    dialogRef.afterClosed().subscribe((data) =>
    {
      console.log(data);
      this.MS.affectEtudiantToEnseignant(etudiant, data.encadrant).subscribe(()=>{
        // or manually add the tool to the existing list
        // this.dataSource.push(toolNew);
        // this.router.navigate(['/dashboard']);
        // Close the dialog
        location.reload();

      });
    });


  }

  
  deleteEtudiant(memberId: number){
    this.MS.deleteEtudiant(memberId).subscribe(()=>{
      this.loadMembers();
    })
  }

}
