/**
 * 
 */
package com.business.cybord.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.AceptacionAvalDto;
import com.business.cybord.services.AceptacionAvalService;

/**
 * @author hha0009
 *
 */
@RestController
@RequestMapping("/api/v1")
public class AceptacionAvalController {
	
	@Autowired
	private AceptacionAvalService service;
	
	
	@GetMapping("/aceptaciones")
	public ResponseEntity<List<AceptacionAvalDto>> findAllAceptaciones() {
		return new ResponseEntity<>(service.findAllAceptaciones(), HttpStatus.OK);
	}
	
	@GetMapping("solicitudes/{idSolicitud}/aceptaciones")
	public ResponseEntity<List<AceptacionAvalDto>> findAceptacionesBySolicitud(@PathVariable Integer idSolicitud) {
		return new ResponseEntity<>(service.findAceptacionesFromSolucitud(idSolicitud), HttpStatus.OK);
	}
	

}
