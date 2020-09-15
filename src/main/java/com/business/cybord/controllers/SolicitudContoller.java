package com.business.cybord.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.SolicitudDto;import com.business.cybord.services.SolicitudService;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudContoller {
	@Autowired
	SolicitudService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<SolicitudDto> getSolicitudById(@PathVariable Integer id) {
		return new ResponseEntity<>(service.getSolicitudById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSolicitudById(@PathVariable Integer id) {
		service.deleteSolicitudById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}