package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AlumnosDao;
import dao.CursoDao;
import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImpl implements FormacionService {
	
	AlumnosDao alumnosDao;
	CursoDao cursosDao;

	public FormacionServiceImpl(@Autowired AlumnosDao alumnosDao, @Autowired CursoDao cursosDao) {
		this.alumnosDao=alumnosDao;
		this.cursosDao=cursosDao;
	}
	
	@Override
	public List<Curso> cursos() {
		return cursosDao.findAll();
	}

	@Override
	public List<Alumno> alumnosCurso(String nombreCurso) {
		return alumnosDao.findByCurso(nombreCurso);
		
	}

	@Override
	public List<Curso> cursoMatriculadoAlumno(String usuario) {
		return cursosDao.findAlumno(usuario);
	}

	@Override
	public Alumno validarUsuario(String usuario, String contrasena) {
		return alumnosDao.findByUsuarioAndPassword(usuario, contrasena);
	}

	@Override
	public Alumno buscarAlumno(String usuario) {
		return alumnosDao.findById(usuario);
	}
	
	@Transactional
	@Override
	public boolean matricularAlumno(String usuario, int idCurso) {
		Alumno alumno = alumnosDao.findById(usuario);
		Curso curso = cursosDao.findById(idCurso);
		if(alumno!=null && curso!=null) {
			alumno.getCursos().add(curso);
			alumnosDao.update(alumno);
			return true;
		}
		return false;
	}

	@Override
	public Curso buscarCurso(int id) {
		return cursosDao.findById(id);
	}
}