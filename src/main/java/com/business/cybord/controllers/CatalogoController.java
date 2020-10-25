package com.business.cybord.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.CatalogoOficinaDto;
import com.business.cybord.services.CatalogoService;

@RestController
@RequestMapping("/api/v1")
public class CatalogoController {
	
	@Autowired
	private CatalogoService service;

	@GetMapping("/catalogos/oficinas")
	public ResponseEntity<List<CatalogoOficinaDto>> getSaldosAhorrosCurrentCaja() {
		return new ResponseEntity<>(service.getCatalogosOficina(), HttpStatus.OK);
	}

}
