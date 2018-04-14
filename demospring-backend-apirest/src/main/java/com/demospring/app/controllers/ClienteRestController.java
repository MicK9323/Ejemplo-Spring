package com.demospring.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demospring.app.models.entity.Cliente;
import com.demospring.app.models.entity.Producto;
import com.demospring.app.models.services.IClienteService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("api/clientes")
public class ClienteRestController {

	@Autowired
	private IClienteService servCliente;
	
	@GetMapping("/listado")
	public List<Cliente> index(){
		return servCliente.listarClientes();
	}
	
	@CrossOrigin
	@GetMapping("/buscar/{id}")
	public Cliente verCliente( @PathVariable int id ) {
		return servCliente.buscarCliente(id);
	}
	
	@PostMapping("/nuevo")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente addCliente( @RequestBody Cliente cliente ) {
		return servCliente.guardarCliente(cliente);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente updateCliente( @RequestBody Cliente cliente, @PathVariable int id ) {
		Cliente actual = servCliente.buscarCliente(id);
		actual.setNombre(cliente.getNombre());
		actual.setApellido(cliente.getApellido());
		actual.setEmail(cliente.getEmail());
		return servCliente.guardarCliente(actual);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCliente( @PathVariable int id ) {
		servCliente.eliminarCliente(id);
	}
	
}
