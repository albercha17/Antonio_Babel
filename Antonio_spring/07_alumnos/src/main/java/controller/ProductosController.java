package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import service.ProductosService;

@CrossOrigin("*")
@Controller
public class ProductosController {
	@Autowired
	ProductosService productosService;
	
	@PostMapping("Alta")
	public String alta(@ModelAttribute Alumno alumno)  {
		productosService.altaAlumno(alumno);
		return "alta";
	}
	@GetMapping(value="BuscadorPorNombre",produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<Alumno> buscarPorNombre(@RequestParam("nombre") String nombre)  {		
		return productosService.buscarPorNombre(nombre);		
	}

	@GetMapping(value="BuscadorPorCurso",produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<Alumno> buscarPorCurso(@RequestParam("curso") String curso)  {		
		return productosService.buscarPorCurso(curso);		
	}
	
	@GetMapping(value="BuscadorTodos",produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<Alumno> buscarTodos()  {		
		return productosService.buscarTodos();		
	}
	@GetMapping(value="BuscadorCursos",produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<String> buscarCursos()  {		
		return productosService.buscarCursos();		
	}
}
