package com.business.cybord.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.RolDto;
import com.business.cybord.services.RolService;

@RestController
@RequestMapping("/usuarios/rol")
public class RolController {
	
	@Autowired
	private RolService service;
	
	@PostMapping("/{idUsuario}")
	public ResponseEntity<RolDto> NewUsuarios(@PathVariable Integer idUsuario,@RequestBody @Valid RolDto rolDto) {
		return new ResponseEntity<>(service.insertNuevoRol(idUsuario,rolDto), HttpStatus.OK);
	}
	

}
