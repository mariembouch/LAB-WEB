import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MemberFormComponent } from './member-form/member-form.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ArticlesComponent } from './articles/articles.component';
import { ToolsComponent } from './tools/tools.component';
import { EventsComponent } from './events/events.component';
import { LoginComponent } from './login/login.component';
import { EventCreateComponent } from './event-create/event-create.component';
import { ToolsCreateComponent } from './tools-create/tools-create.component';
import { EnseignantFormComponent } from './enseignant-form/enseignant-form.component';
import { EtudiantFormComponent } from './etudiant-form/etudiant-form.component';
import { AuthGuard } from 'src/services/auth-guard.service';
import { MemberEtudiantComponent } from './member-etudiant/member-etudiant.component';
import { MemberEnseignantComponent } from './member-enseignant/member-enseignant.component';




const routes: Routes = [

  {path:'dashboard', pathMatch:'full', component:DashboardComponent ,canActivate: [AuthGuard]},
  {path:'articles', pathMatch:'full', component:ArticlesComponent ,canActivate: [AuthGuard]},

  
  {path:'tools', children:[
    {path: '', pathMatch:'full', component:ToolsComponent},
    {path:'create', pathMatch:'full', component:ToolsCreateComponent}], canActivate: [AuthGuard]},

  {path:'events', children:[
    {path: '', pathMatch:'full', component:EventsComponent},
    {path:'create', pathMatch:'full', component:EventCreateComponent},
  ], canActivate: [AuthGuard]},




  {path:'members',
  children:[
    {path: '', pathMatch:'full', component:MemberFormComponent},
    {path:'enseignant/visit/:id/edit', pathMatch:'full', component:EnseignantFormComponent},
    {path:'enseignant/visit/:id/delete', pathMatch:'full', component:EnseignantFormComponent},
    {path:'etudiant/visit/:id/edit', pathMatch:'full', component:EtudiantFormComponent},
    {path:'etudiant/visit/:id/delete', pathMatch:'full', component:EtudiantFormComponent},
    {path:'enseignant/visit/create', pathMatch:'full', component:EnseignantFormComponent},
    {path:'etudiant/visit/create', pathMatch:'full', component:EtudiantFormComponent},
    {path:'enseignant/visit', pathMatch:'full', component:MemberEnseignantComponent ,canActivate: [AuthGuard]},
    {path:'etudiant/visit', pathMatch:'full', component:MemberEtudiantComponent ,canActivate: [AuthGuard]},
  

  ], canActivate: [AuthGuard]},

  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
