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

import com.business.cybord.models.dtos.AtributoSolicitudDto;
import com.business.cybord.services.AtributoSolicitudService;
import com.business.cybord.services.UsuariosService;

@RestController
@RequestMapping
public class AtributoSolicitudController {
	@Autowired
	private AtributoSolicitudService service;
	
	@Autowired
	private UsuariosService serviceUsuario;
	
	@GetMapping("/atributos")
	public ResponseEntity<List<AtributoSolicitudDto>> getSolicitud() {
		return new ResponseEntity<>(service.getAllAtributos(), HttpStatus.OK);
	}
	
	@PostMapping("/usuarios/{idUsuario}/solicitudes/{idSolicitud}/atributos")
	public ResponseEntity<AtributoSolicitudDto> crearAtributo(@PathVariable Integer idUsuario,@PathVariable Integer idSolicitud, @RequestBody @Valid AtributoSolicitudDto atributo) {
		return new ResponseEntity<>(serviceUsuario.createAtributoSolicitud(idUsuario, idSolicitud, atributo), HttpStatus.OK);
	}
	
	@PutMapping("/usuarios/{idUsuario}/solicitudes/{idSolicitud}/atributos/{idAtributo}")
	public ResponseEntity<AtributoSolicitudDto> actualizarAtributo(@PathVariable Integer idUsuario, @PathVariable Integer idSolicitud,@PathVariable Integer idAtributo,  @RequestBody @Valid AtributoSolicitudDto atributo) {
		return new ResponseEntity<>(serviceUsuario.actualizarAtributoSolicitud(idUsuario, idSolicitud, idAtributo, atributo), HttpStatus.OK);
	}
	
	@GetMapping("/usuarios/{idUsuario}/solicitudes/{idSolicitud}/atributos/{idAtributo}")
	public ResponseEntity<AtributoSolicitudDto> getAtributoSolicitudById(@PathVariable Integer idUsuario, @PathVariable Integer idSolicitud,@PathVariable Integer idAtributo) {
		return new ResponseEntity<>(serviceUsuario.getAtributoSolicitudById(idUsuario, idSolicitud, idAtributo), HttpStatus.OK);
	}
	
	@DeleteMapping("/usuarios/{idUsuario}/solicitudes/{idSolicitud}/atributos/{idAtributo}")
	public ResponseEntity<Void> deleteAtributoSolicitudById(@PathVariable Integer idUsuario, @PathVariable Integer idSolicitud,@PathVariable Integer idAtributo) {
		serviceUsuario.deleteAtributoSolicitudById(idUsuario, idSolicitud, idAtributo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
