package com.business.cybord.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.CatalogoDto;
import com.business.cybord.services.CatalogoService;

@RestController
@RequestMapping("/api/v1/catalogos")
public class CatalogosController {

	@Autowired
	private CatalogoService service;

	@GetMapping("/{tipo}")
	public ResponseEntity<List<CatalogoDto>> getCatPropiedadByTipo(@PathVariable String tipo) {
		return new ResponseEntity<>(service.getCatPropiedadByTipo(tipo), HttpStatus.OK);
	}

	@GetMapping("/{tipo}/{nombre}")
	public ResponseEntity<CatalogoDto> getCatPropiedadByTipoAndNombre(@PathVariable String tipo,
			@PathVariable String nombre) {
		return new ResponseEntity<>(service.getCatPropiedadByTipoAndNombre(tipo, nombre), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CatalogoDto> createCatalogoPropiedad(
			@RequestBody @Validated CatalogoDto dto) {
		return new ResponseEntity<>(service.createCatalogoPropiedad(dto), HttpStatus.CREATED);
	}
	
	@PutMapping("/{tipo}/{nombre}")
	public ResponseEntity<CatalogoDto> updatePropiedadByTipoAndNombre(@PathVariable String tipo,
			@PathVariable String nombre, @RequestBody @Validated CatalogoDto dto) {
		return new ResponseEntity<>(service.updateCatalogoPropiedad(tipo, nombre, dto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCatalogoByTipoAndNombre(@PathVariable Integer id) {
		service.deleteCatalogoPropiedadById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
