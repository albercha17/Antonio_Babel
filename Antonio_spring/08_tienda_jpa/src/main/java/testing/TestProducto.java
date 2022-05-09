package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import model.Producto;
import service.ProductosService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {ServiceConfig.class})
public class TestProducto {
	
	@Autowired
	ProductosService service;
	
	@Test
	void testBuscarPorNombre() {
		//producto que existe
		assertEquals("fregona", service.buscarProductoNombre("fregona").getNombre());
		//producto que no existe
		assertNull( service.buscarProductoNombre("cubo"));
	}
}
