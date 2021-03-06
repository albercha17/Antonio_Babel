package service;

import java.util.Date;
import java.util.List;

import dtos.AlumnoDto;
import dtos.CursoDto;
import dtos.MatriculaDto;
import model.Alumno;
import model.Curso;

public interface FormacionService {
	List<AlumnoDto> alumnosCurso(String nombreCurso);
	List<CursoDto> cursoMatriculadoAlumno(String usuario);
	
	AlumnoDto validarUsuario(String usuario,String contraseņa);
	List<CursoDto> cursos();
	List<AlumnoDto> alumnos();
	boolean matricularAlumno(String usuario,int idCurso);
	AlumnoDto buscarAlumno(String usuario);
	CursoDto buscarCurso(int id);
	//NUEVO
	CursoDto buscarCurso(String nombre);
	boolean altaAlumno(AlumnoDto a);
	boolean altaCurso(CursoDto a);
	List<MatriculaDto> matriculasByRange(Date ini,Date end);
	List<CursoDto> cursoNoMatriculadoAlumno(String usuario);
	
}
