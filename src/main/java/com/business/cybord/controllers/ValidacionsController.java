package com.business.cybord.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.services.ValidacionService;

@RestController
@RequestMapping
public class ValidacionsController {
	@Autowired
	private ValidacionService service;

	@GetMapping("/validaciones")
	public ResponseEntity<List<ValidacionDto>> getValidacionById() {
		return new ResponseEntity<>(service.getAllValidaciones(), HttpStatus.OK);
	}

	@GetMapping("/usuarios/{idUsuario}/solicitudes/{idSolicitud}/validaciones")
	public ResponseEntity<List<ValidacionDto>> getValidacionByIdSolicitud(@PathVariable Integer idUsuario,
			@PathVariable Integer idSolicitud) {
		return new ResponseEntity<>(service.getAllValidacionesByIdSolicitud(idSolicitud), HttpStatus.OK);
	}

	@GetMapping("/usuarios/{idUsuario}/solicitudes/{idSolicitud}/validaciones/{idValidacion}")
	public ResponseEntity<ValidacionDto> getValidacionById(@PathVariable Integer idUsuario,
			@PathVariable Integer idSolicitud, @PathVariable Integer idValidacion) {
		return new ResponseEntity<>(service.getValidacionById(idValidacion), HttpStatus.OK);
	}

	@PostMapping("/usuarios/{idUsuario}/solicitudes/{idSolicitud}/validaciones")
	public ResponseEntity<ValidacionDto> crearValidacion(@PathVariable Integer idUsuario,
			@PathVariable Integer idSolicitud, @RequestBody @Valid ValidacionDto validacionDto)
			throws IsbgServiceException {
		return new ResponseEntity<>(service.crearValidacion(idUsuario, idSolicitud, validacionDto), HttpStatus.CREATED);
	}

	@PutMapping("/validaciones/{idValidacion}")
	public ResponseEntity<ValidacionDto> actualizarValidacion(@PathVariable Integer idValidacion,
			@RequestBody @Valid ValidacionDto validacionDto) {
		return new ResponseEntity<>(service.actualizarValidacion(idValidacion, validacionDto), HttpStatus.OK);
	}

	@DeleteMapping("/validaciones/{idValidacion}")
	public ResponseEntity<Void> deleteValidacion(@PathVariable Integer idValidacion) {
		service.deleteValidacion(idValidacion);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
