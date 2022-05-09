package service;

import java.util.List;

import model.Alumno;

public interface AlumnosService {

	List<Alumno> buscarPorCurso(String curso);
	List<Alumno> buscarTodos();
	void altaAlumno(Alumno producto);
	
	
	List<String> buscarCursos();

}