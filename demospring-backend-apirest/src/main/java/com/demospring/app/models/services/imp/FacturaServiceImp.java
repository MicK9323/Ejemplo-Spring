package com.demospring.app.models.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demospring.app.models.dao.IFacturaDao;
import com.demospring.app.models.dao.IProductoDao;
import com.demospring.app.models.entity.Factura;
import com.demospring.app.models.entity.Producto;
import com.demospring.app.models.services.IFacturaService;

@Service
public class FacturaServiceImp implements IFacturaService {
	
	@Autowired
	private IFacturaDao daoFactura;
	
	@Autowired
	private IProductoDao daoProducto;

	@Override
	@Transactional(readOnly=true)
	public List<Producto> buscarProductoxNombre(String term) {
		return daoProducto.buscarPorNombre(term);
	}

	@Override
	@Transactional(readOnly=true)
	public Producto buscarProducto(int id) {
		return daoProducto.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Factura guardarFactura(Factura factura) {
		return daoFactura.save(factura);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Producto> listarProductos() {
		return (ArrayList<Producto>) daoProducto.findAll();
	}

}
