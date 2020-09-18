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
	AtributoSolicitudService service;
	
	@Autowired
	UsuariosService serviceUsuario;
	
	@GetMapping("/atributos")
	public ResponseEntity<List<AtributoSolicitudDto>> getSolicitudById() {
		return new ResponseEntity<>(service.getAllAtributos(), HttpStatus.OK);
	}
	
	@PostMapping("/usuarios/{id_usuario}/solicitudes/{id_solicitud}/atributos")
	public ResponseEntity<AtributoSolicitudDto> crearAtributoById(@PathVariable Integer id_usuario,@PathVariable Integer id_solicitud, @RequestBody @Valid AtributoSolicitudDto atributo) {
		return new ResponseEntity<>(serviceUsuario.createAtributoSolicitud(id_usuario, id_solicitud, atributo), HttpStatus.OK);
	}
	
	@PutMapping("/usuarios/{id_usuario}/solicitudes/{id_solicitud}/atributos/{id_atributo}")
	public ResponseEntity<AtributoSolicitudDto> actualizarAtributoById(@PathVariable Integer id_usuario, @PathVariable Integer id_solicitud,@PathVariable Integer id_atributo,  @RequestBody @Valid AtributoSolicitudDto atributo) {
		return new ResponseEntity<>(serviceUsuario.actualizarAtributoSolicitud(id_usuario, id_solicitud, id_atributo, atributo), HttpStatus.OK);
	}
	
	@GetMapping("/usuarios/{id_usuario}/solicitudes/{id_solicitud}/atributos/{id_atributo}")
	public ResponseEntity<AtributoSolicitudDto> getAtributoSolicitudById(@PathVariable Integer id_usuario, @PathVariable Integer id_solicitud,@PathVariable Integer id_atributo) {
		return new ResponseEntity<>(serviceUsuario.getAtributoSolicitudById(id_usuario, id_solicitud, id_atributo), HttpStatus.OK);
	}
	
	@DeleteMapping("/usuarios/{id_usuario}/solicitudes/{id_solicitud}/atributos/{id_atributo}")
	public ResponseEntity<Void> deleteAtributoSolicitudById(@PathVariable Integer id_usuario, @PathVariable Integer id_solicitud,@PathVariable Integer id_atributo) {
		serviceUsuario.deleteAtributoSolicitudById(id_usuario, id_solicitud, id_atributo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
