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
public class SolicitudesContoller {
	@Autowired
	private SolicitudService service;

	@GetMapping("/solicitudes")
	public ResponseEntity<List<SolicitudDto>> getSolicitudByFiltros() {
		return new ResponseEntity<>(service.getAllSolicitudes(), HttpStatus.OK);
	}

	@GetMapping("/usuarios/{id_usuario}/solicitudes/{id_solicitud}")
	public ResponseEntity<SolicitudDto> getSolicitudById(@PathVariable Integer id_usuario,
			@PathVariable Integer id_solicitud) {
		return new ResponseEntity<>(service.getSolicitudById(id_usuario, id_solicitud), HttpStatus.OK);
	}

	@PostMapping("/usuarios/{idUsuario}/solicitudes")
	public ResponseEntity<SolicitudDto> crearSolicitud(@PathVariable Integer idUsuario,
			@RequestBody @Valid SolicitudDto solicitudDto) {
		return new ResponseEntity<>(service.crearSolicitud(idUsuario, solicitudDto), HttpStatus.CREATED);
	}

	@PutMapping("/solicitudes/{idSolicitud}")
	public ResponseEntity<SolicitudDto> actualizarSolicitudbyId(@PathVariable Integer idSolicitud,
			@RequestBody @Valid SolicitudDto solicitudDto) {
		return new ResponseEntity<>(service.actualizarSolicitudbyId(idSolicitud, solicitudDto), HttpStatus.OK);
	}

	@DeleteMapping("/solicitudes/{idSolicitud}")
	public ResponseEntity<Void> deleteSolicitudById(@PathVariable Integer idSolicitud) {
		service.deleteSolicitudById(idSolicitud);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}