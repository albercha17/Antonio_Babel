package service;

import java.util.List;

import model.Pais;

public interface PaisService {
	List<String> listaContinentes();
	List<Pais> paisPorContinente(String continente);
	long poblacionContinente(String continente);
}
