package com.truper.erikangeles_pt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truper.erikangeles_pt.model.Producto;
import com.truper.erikangeles_pt.repository.ProductoRepo;

@RestController
@RequestMapping("productos")
public class ProductoController {

	@Autowired
	private ProductoRepo dao;

	@PutMapping("cambiaprecio/{id}")
	public ResponseEntity putMethodName(@PathVariable int id, @RequestBody Producto producto) {

		Optional<Producto> producto_viejo = Optional.of(dao.findOne(id));

		if (producto_viejo.isPresent()) {
			producto_viejo.get().setPrecio(producto.getPrecio());
			dao.save(producto_viejo.get());
			return new ResponseEntity<>(producto_viejo.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
