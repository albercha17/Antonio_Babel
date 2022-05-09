package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Alumno;


@Service
public class ProductosServiceImpl implements ProductosService {
	
	@Autowired
	JdbcTemplate template;

	@Override
	public List<Alumno> buscarPorCurso(String curso) {
		String sql="select * from alumnos where curso=?";		
		return template.query(sql, 
				(rs,f)->new Alumno(rs.getInt("idAlumno"),
									 rs.getString("nombre"),
									 rs.getString("curso"),
									 rs.getDouble("nota")), 
				curso);
	}

	@Override
	public List<Alumno> buscarPorNombre(String nombre) {
		String sql="select * from alumnos where nombre=?";		
		return template.query(sql, 
				(rs,f)->new Alumno(rs.getInt("idAlumno"),
									 rs.getString("nombre"),
									 rs.getString("curso"),
									 rs.getDouble("nota")), 
				nombre);
	}

	@Override
	public List<Alumno> buscarTodos() {
		String sql="select * from alumnos";		
		return template.query(sql, 
				(rs,f)->new Alumno(rs.getInt("idAlumno"),
									 rs.getString("nombre"),
									 rs.getString("curso"),
									 rs.getDouble("nota")));
	}

	@Override
	public void altaAlumno(Alumno producto) {
		if(this.buscarPorNombre(producto.getNombre()).isEmpty()) {
			String sql="insert into alumnos(nombre,curso,nota) values(?,?,?)";
		template.update(sql, 
				producto.getNombre(),
				producto.getCurso(),
				producto.getNota());
		}
	}

	@Override
	public List<String> buscarCursos() {
		String sql="select distinct(curso) from alumnos";		
		return template.query(sql, (rs,f)->rs.getString(1));
	}
	
}
