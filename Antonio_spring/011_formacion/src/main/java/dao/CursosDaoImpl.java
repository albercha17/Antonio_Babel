package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.Curso;

@Repository
public class CursosDaoImpl implements CursoDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Curso findById(int idCurso) {
	return entityManager.find(Curso.class, idCurso);
	}

	@Override
	public List<Curso> findAll() {
		String jpql = "select c from Curso c";
		TypedQuery<Curso> query= entityManager.createQuery(jpql, Curso.class);
		return  query.getResultList();
	}

	@Override
	public List<Curso> findAlumno(String usuario) {
		String jpql = "select distinct(c) from Curso c join c.alumnos a where a.usuario =?1";
		TypedQuery<Curso> query= entityManager.createQuery(jpql, Curso.class);
		query.setParameter(1, usuario);
		return query.getResultList();
	}

}
