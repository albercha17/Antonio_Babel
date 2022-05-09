package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;

@Service
public class EscuelaServiceImp implements EscuelaService{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Alumno> alumnosCurso(String nombre) {
		String jpql="select a from Alumno a where a.curso.denominacion=:denominacion";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter("denominacion", nombre);
		List<Alumno> resultList=query.getResultList();
		return resultList;
		
	}

	@Override
	public List<Alumno> alumnosCursoDuracion(int duracion) {
		String jpql="select a from Alumno a where a.curso.duracion<=:duracion";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter("duracion", duracion);
		List<Alumno> resultList=query.getResultList();
		return resultList;
		
	}

	@Override
	public Curso cursoMatriculadoAlumno(String dni) {
		String jpql= "select c from Curso c join c.alumnos a where a.dni=:dni";
		TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter("dni", dni);
		List<Curso> resultList=query.getResultList();
		return resultList.size()>0 ? resultList.get(0) : null ;
	}

	@Override
	public List<Curso> AlumnoSenior(int edad) {
		String jpql= "select c from Curso c join c.alumnos a where a.edad>=:edad";
		TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter("edad", edad);
		List<Curso> resultList=query.getResultList();
		return resultList;
	}

	@Override
	public double edadMediaCurso(String nombre) {
		String jpql = "select avg(a.edad) from Alumno a where a.curso.denominacion=:denominacion"; //avg es para calcular la media y es de sql
		TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
		query.setParameter("denominacion", nombre);
		return query.getSingleResult();

}

	@Override
	public double precioCurso(String email) {
		String jpql= "select c from Curso c join c.alumnos a where a.email=:email"; 
		TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter("email", email);
		List<Curso> resultList=query.getResultList();
		return resultList.get(0).getPrecio();
	}
	}
