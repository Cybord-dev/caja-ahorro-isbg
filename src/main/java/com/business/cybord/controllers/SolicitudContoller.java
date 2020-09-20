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
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.services.SolicitudService;

@RestController
@RequestMapping
public class SolicitudContoller {
	@Autowired
	private SolicitudService service;

	
	@GetMapping("/solicitudes")
	public ResponseEntity<List<SolicitudDto>> getSolicitudById() {
		return new ResponseEntity<>(service.getAllSolicitudes(), HttpStatus.OK);
	}
	
	@PostMapping("/usuarios/{id_usuario}/solicitudes")
	public ResponseEntity<SolicitudDto> crearSolicitudUsuario(@PathVariable Integer id_usuario, @RequestBody @Valid SolicitudDto solicitudDto) {
		return new ResponseEntity<>(service.crearSolicitudUsuario(id_usuario, solicitudDto), HttpStatus.CREATED);
	}
	
	@PutMapping("/usuarios/{id_usuario}/solicitudes/{id_solicitud}")
	public ResponseEntity<SolicitudDto> actualizarSolicitudbyId(@PathVariable Integer id_usuario, @PathVariable Integer id_solicitud, @RequestBody @Valid SolicitudDto solicitudDto) {
		return new ResponseEntity<>(service.actualizarSolicitudbyId(id_usuario, id_solicitud, solicitudDto), HttpStatus.OK);
	}
	
	@GetMapping("/usuarios/{id_usuario}/solicitudes/{id_solicitud}")
	public ResponseEntity<SolicitudDto> getSolicitudById(@PathVariable Integer id_usuario, @PathVariable Integer id_solicitud) {
		return new ResponseEntity<>(service.getSolicitudById(id_usuario,id_solicitud), HttpStatus.OK);
	}
	
	@DeleteMapping("/usuarios/{id_usuario}/solicitudes/{id_solicitud}")
	public ResponseEntity<Void> deleteSolicitudById(@PathVariable Integer id_usuario, @PathVariable Integer id_solicitud) {
		service.deleteSolicitudById(id_usuario, id_solicitud);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}