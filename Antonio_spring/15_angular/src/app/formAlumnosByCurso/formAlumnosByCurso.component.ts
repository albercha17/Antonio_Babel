import { Component, OnInit } from '@angular/core';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';
import { FormacionService } from '../service/formacion.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-formAlumnosByCurso',
  templateUrl: './formAlumnosByCurso.component.html',
  styleUrls: ['./formAlumnosByCurso.component.css']
})
export class FormAlumnosByCursoComponent {

  title:string = "Buscador de Alumnos"
  curso: string ="";
  alumno: string ="";
  cursos: Curso[] | undefined;
  alumnosCurso: Alumno[] | undefined;
  alumnosString: String[] | undefined;

  tableAlumnosHidden:boolean = true;
  constructor(private service : FormacionService,private router: Router){
    service.buscarCursos().subscribe(data => this.cursos=data)
  }
  busquedaAlumnosCurso(){
    this.service.buscarAlumnosCurso(this.curso).subscribe(data => this.alumnosCurso=data);
    this.tableAlumnosHidden= false;
  }
  routeindex(){
    this.router.navigate([
      ''
    
    ]);
  }
}