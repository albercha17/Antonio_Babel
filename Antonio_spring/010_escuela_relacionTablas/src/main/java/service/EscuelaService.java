package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface EscuelaService {
	List<Alumno> alumnosCurso(String nombre);
	List<Alumno> alumnosCursoDuracion(int duracion);
	
	Curso cursoMatriculadoAlumno(String dni);
	List<Curso> AlumnoSenior (int edad); 
	
	double edadMediaCurso(String nombre);
	double precioCurso(String email);
}
