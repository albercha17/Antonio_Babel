package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Hotel;

public interface HotelDao extends JpaRepository<Hotel,Integer>{
	@Query("select a from Hotel a where a.nombre =?1")
	Hotel findByNombre(String nombre);
}
