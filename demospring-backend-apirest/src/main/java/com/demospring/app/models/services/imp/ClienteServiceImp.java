package com.demospring.app.models.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demospring.app.models.dao.IClienteDao;
import com.demospring.app.models.entity.Cliente;
import com.demospring.app.models.services.IClienteService;

@Service
public class ClienteServiceImp implements IClienteService {
	
	@Autowired
	private IClienteDao clientedao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> listarClientes() {
		return (ArrayList<Cliente>) clientedao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Cliente buscarCliente(int id) {
		return clientedao.findById(id).orElse(null);
	}	

	@Override
	@Transactional
	public Cliente guardarCliente(Cliente cliente) {
		return clientedao.save(cliente);
	}

	@Override
	@Transactional
	public void eliminarCliente(int id) {
		clientedao.deleteById(id);
	}

	
}
