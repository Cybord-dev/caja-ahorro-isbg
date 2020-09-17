package com.business.cybord.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.services.SolicitudService;
import com.business.cybord.services.ValidacionService;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudContoller {
	@Autowired
	SolicitudService service;
	
	@Autowired
	ValidacionService validacionService;

	
	@GetMapping
	public ResponseEntity<List<SolicitudDto>> getSolicitudById() {
		return new ResponseEntity<>(service.getAllSolicitudes(), HttpStatus.OK);
	}
	
	
}