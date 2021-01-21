/**
 * 
 */
package com.business.cybord.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.ValidacionAvalDto;
import com.business.cybord.models.error.IsbgServiceException;
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
	public ResponseEntity<Page<ValidacionAvalDto>> findAllAvalesByFiltros(
			@RequestParam Map<String, String> parameters) {
		return new ResponseEntity<>(service.findAllAvalesByFiltros(parameters), HttpStatus.OK);
	}

	@PutMapping("/avales/{id}")
	public ResponseEntity<ValidacionAvalDto> actualizarValidacion(@PathVariable Integer id,
			@RequestBody @Valid ValidacionAvalDto dto) throws IsbgServiceException {
		return new ResponseEntity<>(service.actualizarValidacion(id, dto), HttpStatus.OK);
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
