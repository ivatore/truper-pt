package com.truper.erikangeles_pt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truper.erikangeles_pt.model.Orden;
import com.truper.erikangeles_pt.repository.OrdenRepo;

@RestController
@RequestMapping("orden")
public class OrdenController {

	@Autowired
	private OrdenRepo dao;

	@PostMapping("nueva")
	public ResponseEntity<String> guardaOrdenCompra(@RequestBody Orden orden) {

		orden = dao.save(orden);

		return new ResponseEntity<>("Orden Folio : " + orden.getId(), HttpStatus.CREATED);
	}

	@GetMapping("orden/{idOrden}")
	public ResponseEntity buscarOrden(@PathVariable int id) {

		Optional<Orden> orden = Optional.of(dao.findOne(id));
		if (!orden.isPresent()) {
			return new ResponseEntity<>(new Orden(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(orden.get(), HttpStatus.FOUND);
	}

}
