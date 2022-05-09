import { Component } from '@angular/core';
import { Alumno } from './model/Alumno';
import { Curso } from './model/Curso';
import { FormacionService } from './service/formacion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})

export class AppComponent {
  
  title: string = 'Menú Búsqueda';
  curso: string = '';
  alumno: string = '';
  alumnos: Alumno[] | undefined;
  cursos: Curso[] | undefined;
  alumnosCurso: Alumno[] | undefined;
  cursosAlumno: Curso[] | undefined;
  alumnosString: String[] | undefined;
  tableCursosHidden: boolean = true;
  tableAlumnosHidden: boolean = true;

  constructor(private service: FormacionService, private router: Router) {
    service.buscarCursos().subscribe((data) => (this.cursos = data));
    service.buscarAlumnos().subscribe((data) => (this.alumnos = data));
  }

  busquedaAlumnosCurso() {
    this.service
      .buscarAlumnosCurso(this.curso)
      .subscribe((data) => (this.alumnosCurso = data));
    this.tableCursosHidden = true;
    this.tableAlumnosHidden = false;
  }

  busquedaCursosAlumno() {
    this.service
      .buscarCursosAlumno(this.alumno)
      .subscribe((data) => (this.cursosAlumno = data));
    this.tableCursosHidden = false;
    this.tableAlumnosHidden = true;
  }

  routeAlumnosByCurso() {
    this.router.navigate(['/alumnosByCurso']);
  }

  routeCursosByAlumno() {
    this.router.navigate(['/cursosByAlumno']);
  }
  routeindex() {
    this.router.navigate(['']);
  }

  routeMatricularAlumno() {
    this.router.navigate(['/matricularAlumno']);
  }

  routeConsultarMatriculas() {
    this.router.navigate(['/consultarMatriculas']);
  }
 
}
