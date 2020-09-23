package com.business.cybord.controllers;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.services.SolicitudService;


@RestController
@RequestMapping
public class SolicitudesContoller {
	@Autowired
	private SolicitudService service;
	
	@GetMapping("/usuarios/{idUsuario}/solicitudes")
	public ResponseEntity<List<SolicitudDto>> crearSolicitud(@PathVariable Integer idUsuario) {
		return new ResponseEntity<>(service.getSolicitudByIdUsuario(idUsuario), HttpStatus.CREATED);
	}

	@GetMapping("/usuarios/{idUsuario}/solicitudes/{idSolicitud}")
	public ResponseEntity<SolicitudDto> getSolicitudById(@PathVariable Integer idUsuario,
			@PathVariable Integer idSolicitud) {
		return new ResponseEntity<>(service.getSolicitudByUsuarioAndId(idUsuario, idSolicitud), HttpStatus.OK);
	}
	
	@GetMapping("/solicitudes")
	public ResponseEntity<Page<SolicitudDto>> getPrestamosByParamsController(
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "tipo", required = false) Integer tipo,
			@RequestParam(name = "estatus", required = false) Integer estatus,
			@RequestParam(name = "since", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date since,
			@RequestParam(name = "to", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date to,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		return new ResponseEntity<>(service.getSolicitudesByParametros(email, tipo, estatus, page, size, since, to), HttpStatus.OK);
	}
	
	@PostMapping("/usuarios/{idUsuario}/solicitudes")
	public ResponseEntity<SolicitudDto> crearSolicitud(@PathVariable Integer idUsuario,
			@RequestBody @Valid SolicitudDto solicitudDto) {
		return new ResponseEntity<>(service.crearSolicitud(idUsuario, solicitudDto), HttpStatus.CREATED);
	}

	@PutMapping("/solicitudes/{idSolicitud}")
	public ResponseEntity<SolicitudDto> actualizarSolicitud(@PathVariable Integer idSolicitud,
			@RequestBody @Valid SolicitudDto solicitudDto) {
		return new ResponseEntity<>(service.actualizarSolicitud(idSolicitud, solicitudDto), HttpStatus.OK);
	}

	@DeleteMapping("/solicitudes/{idSolicitud}")
	public ResponseEntity<Void> deleteSolicitud(@PathVariable Integer idSolicitud) {
		service.deleteSolicitud(idSolicitud);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}