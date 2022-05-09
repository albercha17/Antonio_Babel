import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';
import { Matricula } from '../model/Matricula';
import { FormacionService } from '../service/formacion.service';

@Component({
  selector: 'app-matricularAlumno',
  templateUrl: './matricularAlumno.component.html',
  styleUrls: ['./matricularAlumno.component.css'],
})
export class MatricularAlumnoComponent {

  matriculas: Matricula[] | undefined;
  alumnos: Alumno[] | undefined;
  cursos: Curso[] = [];
  title: string = 'Matricular Alumno';
  curso: string = '';
  alumno: string = '';
  idCurso: number = 0;
  tableCursosHidden: boolean = true;

  constructor(private service: FormacionService, private router: Router) {
    service.buscarAlumnos().subscribe((data) => (this.alumnos = data));
    service.buscarCursos().subscribe((data) => (this.cursos = data));
  }

  matricularAlumnoCurso() {
    this.service
      .matricularAlumno(this.idCurso, this.alumno)
      .subscribe((data) => console.log(data));
    this.routeindex();
  }
  
  routeindex() {
    this.router.navigate(['']);
  }
}
