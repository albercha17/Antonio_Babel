import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';
import { Matricula } from '../model/Matricula';

@Injectable({
  providedIn: 'root',
})
export class FormacionService {
  urlAlumnosCurso: string =
    'http://localhost:8080/15_formacion_matriculas/BuscadorAlumnosCurso';
  urlCursosAlumno: string =
    'http://localhost:8080/15_formacion_matriculas/BuscadorCursosAlumno';
  urlCursos: string =
    'http://localhost:8080/15_formacion_matriculas/BuscarCursos';
  urlAlumnos: string =
    'http://localhost:8080/15_formacion_matriculas/BuscarAlumnos';
  urlAltaAlumno: string =
    'http://localhost:8080/15_formacion_matriculas/routeAltaAlumno';
  urlAltaCurso: string =
    'http://localhost:8080/15_formacion_matriculas/routeAltaCurso';
  urlConsultarMatriculasByRange: string =
    'http://localhost:8080/15_formacion_matriculas/BuscadorMatriculasByRange';
  urlMatricularAlumno: string =
    'http://localhost:8080/15_formacion_matriculas/Matricular';


  //urlAlumnosCurso:string="BuscadorAlumnosCurso"
  //urlCursosAlumno:string="BuscadorCursosAlumno"
  //urlCursos:string="BuscarCursos"
  //urlAlumnos:string="BuscarAlumnos"

  cursos: string[] | undefined;
  constructor(private http: HttpClient) { }

  buscarAlumnosCurso(curso: string) {
    return this.http.get<Alumno[]>(this.urlAlumnosCurso, {
      params: { nombreCurso: curso },
    });
  }
  buscarCursosAlumno(alumno: string) {
    return this.http.get<Curso[]>(this.urlCursosAlumno, {
      params: { usuario: alumno },
    });
  }
  buscarMatriculas(dateIni: string, dateFin: string) {
    return this.http.get<Matricula[]>(this.urlConsultarMatriculasByRange, {
      params: { fechaIni: dateIni, fechaFin: dateFin },
    });
  }
  buscarCursos() {
    return this.http.get<Curso[]>(this.urlCursos);
  }
  buscarAlumnos() {
    return this.http.get<Alumno[]>(this.urlAlumnos);
  }
  routeAltaAlumno() {
    return this.http.get<any>(this.urlAltaAlumno);
  }
  routeAltaCurso() {
    return this.http.get<any>(this.urlAltaCurso);
  }
  matricularAlumno(idCurso: number, usuario: string) {
    return this.http.post(`${this.urlMatricularAlumno}?idCurso=${idCurso}&usuario=${usuario}`,null)  
  }
}
