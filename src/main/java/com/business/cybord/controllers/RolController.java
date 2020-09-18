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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.RolDto;
import com.business.cybord.services.RolService;


@RestController
@RequestMapping("/usuarios")
public class RolController {
	
	@Autowired
	private RolService service;
	
	@GetMapping("/roles")
	public ResponseEntity<List<RolDto>> getRolesController() {
		return new ResponseEntity<>(service.getRoles(), HttpStatus.OK);
	}
	
	@PostMapping("/{idUsuario}/roles")
	public ResponseEntity<RolDto> insertNuevoRolController(@PathVariable Integer idUsuario,@RequestBody @Valid RolDto rolDto) {
		return new ResponseEntity<>(service.insertNuevoRol(idUsuario,rolDto), HttpStatus.OK);
	}
	
	@GetMapping("/{idUsuario}/roles")
	public ResponseEntity<List<RolDto>> getRolesByUserIdController(@PathVariable Integer idUsuario) {
		return new ResponseEntity<>(service.getRolesPorUsuarioId(idUsuario), HttpStatus.OK);
	}
	
	@DeleteMapping("/{idUsuario}/roles/{idRol}")
	public ResponseEntity<Void> deleteUserRolesController(@PathVariable Integer idRol, @PathVariable Integer idUsuario) {
		service.borrarRolePorUsuarioIdyIdRol(idUsuario, idRol);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
