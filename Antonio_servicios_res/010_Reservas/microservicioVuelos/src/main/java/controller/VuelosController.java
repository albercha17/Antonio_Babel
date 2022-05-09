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

import model.Vuelo;

import service.VuelosService;


@RestController
public class VuelosController {
		@Autowired
		VuelosService service;
		
		@PutMapping(value="actualizarVuelo",produces=MediaType.TEXT_PLAIN_VALUE)
		public String actualizarPlazas(@RequestParam("idVuelo") int idVuelo,@RequestParam("plazas") int plazas) {
			return String.valueOf(service.actualizarPlazas(plazas, idVuelo));
		}
		@GetMapping(value ="VuelosDisponibles/{plazas}",produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Vuelo> vuelosDisponibles(@PathVariable("plazas") int plazas){
			List<Vuelo> v=service.vuelosDisponibles(plazas);
			return service.vuelosDisponibles(plazas);
		}
}
