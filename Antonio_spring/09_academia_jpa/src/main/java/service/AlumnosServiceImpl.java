package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Service
public class AlumnosServiceImpl implements AlumnosService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Override
	public List<Alumno> buscarPorCurso(String curso) {
		TypedQuery<Alumno> query;
		query = entityManager.createNamedQuery("Alumno.findByCurso", Alumno.class);
		query.setParameter("curso", curso);
		List<Alumno> resultList = query.getResultList();
		 return resultList;
	}
	
	@Transactional
	@Override
	public List<Alumno> buscarTodos() {
		TypedQuery<Alumno> query;
		query = entityManager.createNamedQuery("Alumno.findAll", Alumno.class);
		List<Alumno> resultList = query.getResultList();
		 return resultList;
	}
	@Transactional
	@Override
	public void altaAlumno(Alumno alumno) {
		TypedQuery<Alumno> query;
		query = entityManager.createNamedQuery("Alumno.findByNombre", Alumno.class);
		query.setParameter("nombre", alumno.getNombre());
		List<Alumno> resultList = query.getResultList();
		if(resultList.isEmpty())
			entityManager.persist(alumno);
	}
	
	@Transactional
	@Override
	public List<String> buscarCursos() {
		TypedQuery<String> query;
		query = entityManager.createNamedQuery("Alumno.findCursos", String.class);
		return query.getResultList();
	}
	
}
