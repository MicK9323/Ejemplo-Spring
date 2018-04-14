package com.demospring.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.demospring.app.models.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Integer> {
	
	

}
