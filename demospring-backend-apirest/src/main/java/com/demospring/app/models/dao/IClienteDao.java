package com.demospring.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.demospring.app.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Integer> {
	
	
	
}
