package service;

import java.util.List;

import model.Alumno;

public interface ProductosService {

	List<Alumno> buscarPorCurso(String curso);
	List<Alumno> buscarPorNombre(String nombre);
	List<Alumno> buscarTodos();
	void altaAlumno(Alumno producto);
	
	
	List<String> buscarCursos();

}