package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Hotel;

import service.HotelesService;


@RestController
public class HotelesController {
		@Autowired
		HotelesService service;
		@GetMapping(value ="HotelesDisponibles",produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Hotel> hotelesDisponibles(){
			return service.hotelesDisponibles();
		}
		@GetMapping(value ="Hotel/{nombre}",produces=MediaType.APPLICATION_JSON_VALUE)
		public Hotel hola(@PathVariable String nombre){
			Hotel h = service.hotelPorNombre(nombre);
			return h;
		}
}
