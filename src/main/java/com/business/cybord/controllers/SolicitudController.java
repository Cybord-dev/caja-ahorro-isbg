package com.business.cybord.controllers;

import org.jeasy.states.api.FiniteStateMachineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.services.SolicitudesService;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

	@Autowired 
	private SolicitudesService service;
	
	@PostMapping("/validar")
	public ResponseEntity<SolicitudDto> validarSolicitud(@RequestBody SolicitudDto dto) throws FiniteStateMachineException {
		return new ResponseEntity<>(service.validarSolicitud(dto), HttpStatus.OK);
	}
}
