package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface CursoDao extends JpaRepository<Curso, Integer> {
	
	@Query("select distinct(c) from Curso c join c.alumnos a where a.usuario =?1")
	List<Curso> findAlumno(String usuario);
	
	List<Curso> findByNombre(String nombre);
	@Query("Select c From Curso c Where c Not In (Select c From Curso c join c.alumnos a Where a.usuario=?1)")
	List<Curso> findCursosNoMatriculados(String usuario);
	
	List<Curso> findByFechaInicioBetween(Date fechaInicio, Date fechaFin);
}
