import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormAlumnosByCursoComponent } from './formAlumnosByCurso/formAlumnosByCurso.component';
import { FormCursosByAlumnoComponent } from './formCursosByAlumno/formCursosByAlumno.component';
import { AppRoutingModule } from './app-routing.module';
import { MenuBusquedasComponent } from './menuBusquedas/menuBusquedas.component';
import { MatricularAlumnoComponent } from './matricularAlumno/matricularAlumno.component';
import { ConsultarMatriculasComponent } from './consultarMatriculas/consultarMatriculas.component';


@NgModule({
  declarations: [						
    AppComponent,
      FormAlumnosByCursoComponent,
      FormCursosByAlumnoComponent,
      MenuBusquedasComponent,
      MatricularAlumnoComponent,
      ConsultarMatriculasComponent
   ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
