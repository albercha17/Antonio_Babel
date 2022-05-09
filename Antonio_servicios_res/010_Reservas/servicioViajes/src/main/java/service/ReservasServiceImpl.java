package service;


import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservaDao;
import dto.ReservaDto;
import model.Hotel;
import model.Reserva;
import model.Vuelo;

@Service
public class ReservasServiceImpl implements ReservasService {
	
	RestTemplate template;
	String urlVuelos="http://localhost:8100/agencia/";
	String urlHoteles="http://localhost:8000/agencia/";
	
	ReservaDao reservaDao;
	
	Hotel[] hoteles;
	Vuelo[] vuelos;
	
	public ReservasServiceImpl(@Autowired ReservaDao reservaDao,@Autowired RestTemplate template) {
		super();
		this.reservaDao = reservaDao;
		this.template=template;
	}
	@PostConstruct
	public void init(){
		this.hoteles= template.getForObject(urlHoteles+"HotelesDisponibles", Hotel[].class);
	}
	@Override
	public boolean reservar(ReservaDto reserva) {
		
		boolean sePuedeHotel=false;
		boolean sePuedeVuelo=false;
		vuelos=template.getForObject(urlVuelos+"VuelosDisponibles/"+ reserva.getPlazas(), Vuelo[].class);
		for(Hotel h : hoteles) {
			if(h.getIdHotel()==reserva.getHotel()) {
				sePuedeHotel=true;
			}
		}
		for(Vuelo h : vuelos) {
			if(h.getIdVuelo()==reserva.getVuelo()) {
				sePuedeVuelo=true;
			}
		}
		if(sePuedeVuelo&&sePuedeHotel) {
			Reserva r = new Reserva(reserva.getIdReserva(), reserva.getNombre(), reserva.getDni(),
					reserva.getHotel(),reserva.getVuelo());
			reservaDao.save(r);
			template.put(urlVuelos+"/actualizarVuelo/"+"?idVuelo="+r.getVuelo()+"&plazas="+reserva.getPlazas(),null);
			 return true;
		}
		return false;
	}



	

}
