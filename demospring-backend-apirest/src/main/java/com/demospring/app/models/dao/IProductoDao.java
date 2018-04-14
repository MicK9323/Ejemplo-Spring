package com.demospring.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demospring.app.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Integer> {
	
	@Query("select p from Producto p where p.descripcion like %?1%")
	public List<Producto> buscarPorNombre(String term);
	
//	public List<Producto> findbyDescripcionLikeIgnoreCase(String term);
	
}
