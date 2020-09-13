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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.CatalogoPropiedadDto;
import com.business.cybord.services.CatalogoPropiedadService;

@RestController
@RequestMapping("/catalogos")
public class CatalogoPropiedadController {

	@Autowired
	private CatalogoPropiedadService service;
	
	@GetMapping("/{tipo}")
	public ResponseEntity<List<CatalogoPropiedadDto>> getCatPropiedadByTipo(@PathVariable String tipo){
		return new ResponseEntity<>(service.getCatPropiedadByTipo(tipo), HttpStatus.OK);
	}
	
	@GetMapping("/{tipo}/{nombre}")
	public ResponseEntity<CatalogoPropiedadDto> getCatPropiedadByTipoAndNombre(@PathVariable String tipo, @PathVariable String nombre){
		return new ResponseEntity<>(service.getCatPropiedadByTipoAndNombre(tipo, nombre), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CatalogoPropiedadDto> createCatalogoPropiedad(@RequestBody @Validated CatalogoPropiedadDto dto){
		return new ResponseEntity<>(service.createCatalogoPropiedad(dto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{tipo}/{nombre}")
	public ResponseEntity<Void> deleteCatalogoByTipoAndNombre(@PathVariable String tipo, @PathVariable String nombre) {
		service.deleteCatalogoPropiedadByTipoAndNombre(tipo, nombre);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
