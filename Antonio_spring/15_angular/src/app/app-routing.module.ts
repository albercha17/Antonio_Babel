import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormAlumnosByCursoComponent } from './formAlumnosByCurso/formAlumnosByCurso.component';
import { FormCursosByAlumnoComponent } from './formCursosByAlumno/formCursosByAlumno.component';
import { MenuBusquedasComponent } from './menuBusquedas/menuBusquedas.component';
import { MatricularAlumnoComponent } from './matricularAlumno/matricularAlumno.component';
import { ConsultarMatriculasComponent } from './consultarMatriculas/consultarMatriculas.component';
const routes: Routes = [

      {
        path : 'alumnosByCurso',
        component : FormAlumnosByCursoComponent
      },
      {
        path : 'cursosByAlumno',
        component : FormCursosByAlumnoComponent
      },
      {
        path : 'matricularAlumno',
        component : MatricularAlumnoComponent
      },
      {
        path : 'consultarMatriculas',
        component : ConsultarMatriculasComponent
      },
      
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }