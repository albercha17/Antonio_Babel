package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import model.Alumno;
import model.Curso;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class} )
public class TestFormacion {
	@Autowired 
	FormacionService service;
	
	@Test void testValidaraAlumno() {
		
		assertEquals("tomates",service.validarUsuario("admin", "a").getNombre());
	}
	
	@Test void testCursoMatriculadoAlumno() {
		assertEquals(2,service.cursoMatriculadoAlumno("aaa").size());
	}
	
	@Test void testListaCursos() {
		assertNotEquals(null,service.cursos());
	}
	@Test void altaAlumno() {
		Alumno a = new Alumno("alberto","123","Alberto","albercha@ucm.es",23);
		assertEquals(false,service.altaAlumno(a));
	}

	@Test void altaCurso() {
		Calendar c1 = Calendar.getInstance();
		c1.set(2020,8,20);
		Date f1=c1.getTime();
		Curso a = new Curso(19,"babelCurso",500,230,f1);
		assertEquals(false,service.altaCurso(a));
	}
	
	@Test void cursosNoMatriculados() {
		List<Curso> list = service.findCursosNoMatriculados("admin");
		List<Curso> list2 = service.cursoMatriculadoAlumno("admin");
		assertNotEquals(list2,list);
	}
}