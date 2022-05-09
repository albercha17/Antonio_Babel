package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Producto;


@Service
public class ProductosServiceImpl implements ProductosService {
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Override
	public List<Producto> productosSeccion(String seccion) {
		TypedQuery<Producto> query;
		query = entityManager.createNamedQuery("Producto.findBySeccion", Producto.class);
		query.setParameter("seccion", seccion);
		
		List<Producto> resultList = query.getResultList();
		
		
		 return resultList;
	}
	
	@Transactional
	@Override
	public void altaProducto(Producto producto) {
		entityManager.persist(producto);
		
	}
	@Transactional
	@Override
	public void eliminarProducto(String nombre) {
		Producto p= this.buscarProductoNombre(nombre);
		if( p!= null )entityManager.remove(p);
		
	}
	@Transactional
	@Override
	public void modificarPrecioProducto(String nombre, double nuevoPrecio) {
		Producto p= this.buscarProductoNombre(nombre);
		if(p!=null) {
			p.setPrecio(nuevoPrecio);
			entityManager.merge(p);
		}
		
	}
	@Transactional
	@Override
	public Producto buscarProducto(int idProducto) {
		//Solo busca por primary key
		return entityManager.find(Producto.class, idProducto);
	}
	@Transactional
	@Override
	public Producto buscarProductoNombre(String nombre) {
		TypedQuery<Producto> query;
		query = entityManager.createNamedQuery("Producto.findByNombre", Producto.class);
		query.setParameter("nombre", nombre);
		List<Producto> resultList = query.getResultList();
		 return resultList.size()>0 ? resultList.get(0) : null;
	}
	
}
