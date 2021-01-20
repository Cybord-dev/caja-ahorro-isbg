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

import com.business.cybord.models.dtos.ValidacionAvalDto;
import com.business.cybord.services.ValidacionAvalService;

/**
 * @author hha0009
 *
 */
@RestController
@RequestMapping("/api/v1")
public class ValidacionAvalController {
	
	@Autowired
	private ValidacionAvalService service;
	
	@GetMapping("/avales")
	public ResponseEntity<List<ValidacionAvalDto>> findAllAvalesByFiltros() {
		return new ResponseEntity<>(service.findAllAvalesByFiltros(), HttpStatus.OK);
	}
	
	@GetMapping("usuarios/{noEmpleado}/avales")
	public ResponseEntity<List<ValidacionAvalDto>> findAvalesNotApprovedByEmpleado(@PathVariable String noEmpleado) {
		return new ResponseEntity<>(service.findAvalesNotApprovedByEmpleado(noEmpleado), HttpStatus.OK);
	}
	
	@GetMapping("solicitudes/{idSolicitud}/avales")
	public ResponseEntity<List<ValidacionAvalDto>> findAvalesBySolicitud(@PathVariable Integer idSolicitud) {
		return new ResponseEntity<>(service.findAvalesBySolicitud(idSolicitud), HttpStatus.OK);
	}
	

}
