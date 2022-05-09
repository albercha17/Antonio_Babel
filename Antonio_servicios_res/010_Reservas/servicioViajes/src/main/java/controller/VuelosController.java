package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.ReservaDto;
import model.Reserva;
import service.ReservasService;


@RestController
public class VuelosController {
		@Autowired
		ReservasService service;
		
		@PostMapping(value="Reservar",produces=MediaType.TEXT_PLAIN_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
		public boolean actualizarPlazas(@RequestBody ReservaDto reserva) {
			return service.reservar(reserva);
		}
}
