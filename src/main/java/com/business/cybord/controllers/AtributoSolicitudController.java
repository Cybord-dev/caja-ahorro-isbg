package com.business.cybord.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.AtributoSolicitudDto;
import com.business.cybord.services.AtributoSolicitudService;

@RestController
@RequestMapping("/atributos")
public class AtributoSolicitudController {
	@Autowired
	AtributoSolicitudService service;
	
	@GetMapping
	public ResponseEntity<List<AtributoSolicitudDto>> getSolicitudById() {
		return new ResponseEntity<>(service.getAllAtributos(), HttpStatus.OK);
	}
}
