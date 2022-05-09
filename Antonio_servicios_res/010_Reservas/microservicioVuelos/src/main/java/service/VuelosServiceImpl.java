package service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VueloDao;
import model.Vuelo;

@Service
public class VuelosServiceImpl implements VuelosService {
	
	VueloDao vuelosDao;
	
	public VuelosServiceImpl(@Autowired VueloDao vuelosDao) {
		super();
		this.vuelosDao = vuelosDao;
	}

	@Override
	public boolean actualizarPlazas(int plazas,int id) {
		Vuelo aux = vuelosDao.findById(id);
		if(aux!=null) {
			aux.setPlazas(aux.getPlazas()-plazas);
			vuelosDao.save(aux);
			return true;
		}
		return false;
	}

	@Override
	public List<Vuelo> vuelosDisponibles(int plazas) {
		List<Vuelo> v =vuelosDao.findAll();
		return vuelosDao.findAll().stream()
                .filter(aux -> aux.getPlazas()>=plazas)
                .distinct()
                .collect(Collectors.toList());
	}



	

}
