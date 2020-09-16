package com.business.cybord.controllers;

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
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.services.SolicitudService;
import com.business.cybord.services.ValidacionService;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudContoller {
	@Autowired
	SolicitudService service;
	
	@Autowired
	ValidacionService validacionService;

	
	@GetMapping("/{id}")
	public ResponseEntity<SolicitudDto> getSolicitudById(@PathVariable Integer id) {
		return new ResponseEntity<>(service.getSolicitudById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSolicitudById(@PathVariable Integer id) {
		service.deleteSolicitudById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PostMapping("/{id}/atributos")
	public ResponseEntity<AtributoSolicitudDto> crearAtributoById(@PathVariable Integer id, @RequestBody @Valid AtributoSolicitudDto atributo) {
		return new ResponseEntity<>(service.createAtributoSolicitud(id, atributo), HttpStatus.OK);
	}
	
	@PutMapping("{id}/atributos/{id_atributo}")
	public ResponseEntity<AtributoSolicitudDto> actualizarAtributoById(@PathVariable Integer id, @PathVariable Integer id_atributo, @RequestBody @Valid AtributoSolicitudDto atributo) {
		return new ResponseEntity<>(service.actualizarAtributoSolicitud(id, id_atributo, atributo), HttpStatus.OK);
	}
}