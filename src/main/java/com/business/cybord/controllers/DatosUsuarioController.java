package com.business.cybord.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.DatosUsuarioDto;
import com.business.cybord.services.DatoUsuarioService;

@RestController
@RequestMapping("/datos")
public class DatosUsuarioController {
	
	@Autowired
	private DatoUsuarioService service;

	@PostMapping("")
	public ResponseEntity<DatosUsuarioDto> insertarNuevoDatoUsuario(
			@RequestBody @Valid DatosUsuarioDto datousuarioDto) {
		return new ResponseEntity<>(service.insertarNuevoDatoUsuario(datousuarioDto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DatosUsuarioDto> actualizarDatoUsuario(@RequestBody @Valid DatosUsuarioDto datousuarioDto,
			@PathVariable Integer id) {
		return new ResponseEntity<>(service.actualizarDatoUsuario(id, datousuarioDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarDatoUsuario(@PathVariable Integer id) {
		service.borraDatoUsuario(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
