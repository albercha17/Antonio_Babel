import { Component, OnInit } from '@angular/core';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';
import { FormacionService } from '../service/formacion.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-formCursosByAlumno',
  templateUrl: './formCursosByAlumno.component.html',
  styleUrls: ['./formCursosByAlumno.component.css']
})
export class FormCursosByAlumnoComponent {

  title:string = "Buscador de Cursos"
  curso: string ="";
  alumno: string ="";
  alumnos: Alumno[] | undefined;
  cursosAlumno: Curso[] | undefined;
  alumnosString: String[] | undefined;
  tableCursosHidden:boolean= true;

  constructor(private service : FormacionService,private router: Router){
   
    service.buscarAlumnos().subscribe(data => this.alumnos=data)
  }

  busquedaCursosAlumno(){
    this.service.buscarCursosAlumno(this.alumno).subscribe(data => this.cursosAlumno=data);
    this.tableCursosHidden= false;
  }
  routeindex(){
    this.router.navigate([
      ''
    ]);
  }
}