package controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import model.Curso;
import service.FormacionService;

@CrossOrigin("*")
@Controller
public class FormacionController {
	@Autowired
	FormacionService formacionService;
	
	@GetMapping(value="listaCursos",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> listaCursos()  {
		return formacionService.cursos();
	}
	
	@GetMapping(value="alumnosCurso",produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<Alumno> alumnosCurso(@RequestParam("curso") String curso)  {		
		return formacionService.alumnosCurso(curso);		
	}
	
	@GetMapping(value="cursoMatriculadoAlumno",produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<Curso> cursoMatriculadoAlumno(@RequestParam("usuario") String usuario)  {		
		return formacionService.cursoMatriculadoAlumno(usuario);
	}
	
	@PostMapping(value="login")	
	public  String validarUsuario(@RequestParam("usuario") String usuario,@RequestParam("password") String password)  {		
		Alumno a= formacionService.validarUsuario(usuario,password);
		if(a==null)
			return "login";
		else
			return "inicio";
	}
	
	@PostMapping(value="matricularAlumno")	
	public  String matricularAlumno(@RequestParam("usuario") String usuario,@RequestParam("curso") int curso)  {		
		boolean a= formacionService.matricularAlumno(usuario,curso);
			return "inicio";
	}
	
	@PostMapping(value="AltaCurso")	
	public  String altaCurso(@ModelAttribute Curso curso)  {	
		if(formacionService.altaCurso(curso))
			return "inicio";
		else
			return "AltaCurso";
	}
	
	@PostMapping(value="AltaAlumno")	
	public  String altaAlumno(@ModelAttribute Alumno alumno)  {	
		if(formacionService.altaAlumno(alumno))
			return "inicio";
		else
			return "AltaALumno";
	}
	
	@GetMapping(value="listaCursosNoMatriculados",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> listaCursosNoMatriculados(@RequestParam("usuario") String usuario)  {
		return formacionService.findCursosNoMatriculados(usuario);
	}
	
	@GetMapping(value="listaCursosFecha",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> listaCursosFecha(@RequestParam("fechaInicio")@DateTimeFormat(pattern= "yyyy-MM-dd") Date fechaInicio,
			@RequestParam("fechaInicio") @DateTimeFormat(pattern= "yyyy-MM-dd") Date fechaFin)  {
		return formacionService.findCursosFecha(fechaInicio,fechaFin);
	}
}

