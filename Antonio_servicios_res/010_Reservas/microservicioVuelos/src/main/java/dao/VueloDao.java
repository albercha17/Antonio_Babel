package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Vuelo;

public interface VueloDao extends JpaRepository<Vuelo,Integer>{
	@Query("select a from Vuelo a where a.idVuelo =?1")
	Vuelo findById(int id);
}
