package com.demospring.app.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demospring.app.models.entity.Cliente;

public interface IClienteService {

		public List<Cliente> listarClientes();
		public Cliente guardarCliente(Cliente cliente);		
		public void eliminarCliente(int id);
		public Cliente buscarCliente(int id);
		
}
