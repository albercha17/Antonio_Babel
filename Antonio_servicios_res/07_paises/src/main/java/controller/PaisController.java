package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Pais;
import service.PaisService;

@RestController
public class PaisController {
	@Autowired
	PaisService service;
	
	@GetMapping(value="continentes",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes(){
		return service.listaContinentes();
	}
	@GetMapping(value="paises/{continente}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> estudiantesPuntuacion(@PathVariable("continente") String continente){
		return service.paisPorContinente(continente);
	}
	@GetMapping(value="poblacion/{continente}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String poblacionPorContinente(@PathVariable("continente") String continente){
		return "Poblacion de "+continente+":"+String.valueOf(service.poblacionContinente(continente));
	}
}
