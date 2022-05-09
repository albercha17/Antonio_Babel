package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import model.Alumno;
import model.Curso;
import service.EscuelaService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {ServiceConfig.class})
public class TestEscuela {
	
	@Autowired
	EscuelaService service;
	
	@Test
	void testAlumnosCurso() {
		List<Alumno> p = service.alumnosCurso("java");
		assertEquals(p.size(), 4);
	}
	
	@Test
	void testAlumnosCursoDuracion() {
		List<Alumno> p = service.alumnosCursoDuracion(100);
		assertEquals(p.size(), 3);
	}
	
	@Test
	void testCursoMatriculadoAlumno() {
		Curso c = service.cursoMatriculadoAlumno("1111A");
		assertEquals(c.getDenominacion(), "java");
		Curso c1 = service.cursoMatriculadoAlumno("1111B");
		assertEquals(c1, null);
	}
	
	@Test
	void testAlumnoSenior() {
		List<Curso> c = service.AlumnoSenior(38);
		assertEquals(c.size(), 2);
	}
	
	@Test
	void testEdadMediaCurso() {
		Double media = service.edadMediaCurso("java");
		assertEquals(media, 25);
	}
	
	@Test
	void testPrecioCurso() {
		Double precio = service.precioCurso("primero@gmail.com");
		assertEquals(precio,250);
	}
	
}
