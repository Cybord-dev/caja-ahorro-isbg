package com.business.cybord.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.RecursoDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.models.dtos.composed.UserValidacionSolicitudDto;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.services.ValidacionService;

@RestController
@RequestMapping("/api/v1")
public class ValidacionsController {
	@Autowired
	private ValidacionService service;

	@GetMapping("/validaciones")
	public ResponseEntity<Page<UserValidacionSolicitudDto>> getValidaciones(
			@RequestParam Map<String, String> parameters) {
		return new ResponseEntity<>(service.getAllValidaciones(parameters), HttpStatus.OK);
	}
	
	@GetMapping("/validaciones/report")
	public ResponseEntity<RecursoDto> getValidacionesReport(
			@RequestParam Map<String, String> parameters) throws IOException {
		return new ResponseEntity<>(service.getValidacionesReport(parameters), HttpStatus.OK);
	}

	@GetMapping("/usuarios/{idUsuario}/solicitudes/{idSolicitud}/validaciones")
	public ResponseEntity<List<ValidacionDto>> getValidacionByIdSoolicitud(@PathVariable Integer idUsuario,
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
