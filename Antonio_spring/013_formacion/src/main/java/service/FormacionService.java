package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import model.Alumno;
import model.Curso;

public interface FormacionService {
	List<Alumno> alumnosCurso(String nombreCurso);
	List<Curso> cursoMatriculadoAlumno(String usuario);
	Alumno validarUsuario(String usuario,String contraseņa);
	List<Curso> cursos();
	List<Alumno> alumnos();
	boolean matricularAlumno(String usuario,int idCurso);
	List<Curso> findCursosNoMatriculados(String usuario);
	boolean altaCurso(Curso curso);
	boolean altaAlumno(Alumno alumno);
	List<Curso> findCursosFecha(Date fechaInicio, Date fechaFin);
}