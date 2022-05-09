package service;

import java.util.List;

import model.Vuelo;


public interface VuelosService {
	List<Vuelo> vuelosDisponibles(int plazas);
	boolean actualizarPlazas(int plazas,int id);
}
