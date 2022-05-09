package service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HotelDao;
import model.Hotel;

@Service
public class HotelesServiceImpl implements HotelesService {
	
	HotelDao hotelesDao;
	
	public HotelesServiceImpl(@Autowired HotelDao hotelesDao) {
		super();
		this.hotelesDao = hotelesDao;
	}

	@Override
	public List<Hotel> hotelesDisponibles() {
		return hotelesDao.findAll().stream()
                .filter(aux -> aux.isDisponible())
                .distinct()
                .collect(Collectors.toList());
	}

	@Override
	public Hotel hotelPorNombre(String nombre) {
		return hotelesDao.findByNombre(nombre);
	}



	

}
