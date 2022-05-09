package service;

import java.util.List;

import dto.ReservaDto;
import model.Reserva;


public interface ReservasService {
	boolean reservar(ReservaDto reserva);
}
