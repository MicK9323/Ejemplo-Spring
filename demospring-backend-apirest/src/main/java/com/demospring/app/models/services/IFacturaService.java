package com.demospring.app.models.services;

import java.util.List;

import com.demospring.app.models.entity.Factura;
import com.demospring.app.models.entity.Producto;

public interface IFacturaService {
	
	public List<Producto> buscarProductoxNombre(String term);
	public Producto buscarProducto(int id);
	public Factura guardarFactura(Factura factura);
	public List<Producto> listarProductos();

}
