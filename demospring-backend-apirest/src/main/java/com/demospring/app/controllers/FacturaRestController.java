package com.demospring.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demospring.app.models.entity.Cliente;
import com.demospring.app.models.entity.Factura;
import com.demospring.app.models.entity.Producto;
import com.demospring.app.models.services.IClienteService;
import com.demospring.app.models.services.IFacturaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("api/facturas")
public class FacturaRestController {
	
	@Autowired
	IFacturaService servfactura;
	
	@Autowired
	private IClienteService servCliente;
	
	@GetMapping("/productos")
	public List<Producto> listarProductos(){
		return servfactura.listarProductos();
	}
	
	@GetMapping("/productos/{term}")
	public List<Producto> buscarProductosxNombre( @PathVariable String term ){
		return servfactura.buscarProductoxNombre(term);
	}
	
	@GetMapping("/producto/{id}")
	public Producto buscarProducto( @PathVariable int id ) {
		return servfactura.buscarProducto(id);
	}
	
	@GetMapping("/registrar/{id}")
	public Cliente buscarCliente(@PathVariable int id) {
		return servCliente.buscarCliente(id);
	}
	
	@PostMapping("/registrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura regFactura( @RequestBody Factura factura ) {
		return servfactura.guardarFactura(factura);
	}
	
	
}
