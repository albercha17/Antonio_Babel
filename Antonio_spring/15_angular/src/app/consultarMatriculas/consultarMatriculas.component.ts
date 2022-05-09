import { Component, OnInit } from '@angular/core';
import { FormacionService } from '../service/formacion.service';
import { Router } from '@angular/router';
import { Matricula } from '../model/Matricula';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';
@Component({
  selector: 'app-consultarMatriculas',
  templateUrl: './consultarMatriculas.component.html',
  styleUrls: ['./consultarMatriculas.component.css'],
})
export class ConsultarMatriculasComponent  {

  title: string = 'Consultar Matriculas';
  matriculas: Matricula[] | undefined;
  alumnos: Alumno[] | undefined;
  cursos: Curso[] | undefined;

  dateIni: string = '';
  dateFin: string = '';

  cursosAlumno: Curso[] | undefined;
  alumnosString: String[] | undefined;
  tableAlumnosHidden: boolean = true;

  constructor(private service: FormacionService, private router: Router) {}
 
  routeindex() {
    this.router.navigate(['']);
  }

  consultarMatriculas() {
    console.log(this.dateIni);
    this.service
      .buscarMatriculas(this.dateIni, this.dateFin)
      .subscribe((data) => (this.matriculas = data));
    this.tableAlumnosHidden = false;
  }
  
}
