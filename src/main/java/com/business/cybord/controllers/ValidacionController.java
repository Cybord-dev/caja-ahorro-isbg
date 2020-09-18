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

import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.services.UsuariosService;
import com.business.cybord.services.ValidacionService;

@RestController
@RequestMapping
public class ValidacionController {
	@Autowired
	ValidacionService service;
	
	@Autowired
	UsuariosService serviceUsuario;
	
	@GetMapping("/validaciones")
	public ResponseEntity<List<ValidacionDto>> getValidacionById() {
		return new ResponseEntity<>(service.getAllValidaciones(), HttpStatus.OK);
	}
	
	@PostMapping("/usuarios/{id_usuario}/solicitudes/{id_solicitud}/validaciones")
	public ResponseEntity<ValidacionDto> crearValidacionesUsuario(@PathVariable Integer id_usuario,@PathVariable Integer id_solicitud ,@RequestBody @Valid ValidacionDto validacionDto) {
		return new ResponseEntity<>(serviceUsuario.crearValidacion(id_usuario,id_solicitud, validacionDto), HttpStatus.OK);
	}
	
	
	@PutMapping("/usuarios/{id_usuario}/solicitudes/{id_solicitud}/validaciones/{id_validacion}")
	public ResponseEntity<ValidacionDto> actualizarValidacionbyId(@PathVariable Integer id_usuario,@PathVariable Integer id_solicitud,@PathVariable Integer id_validacion, @RequestBody @Valid ValidacionDto validacionDto) {
		return new ResponseEntity<>(serviceUsuario.actualizarValidacionById(id_usuario, id_solicitud,id_validacion,validacionDto), HttpStatus.OK);
	}
	
	@GetMapping("/usuarios/{id_usuario}/solicitudes/{id_solicitud}/validaciones/{id_validacion}")
	public ResponseEntity<ValidacionDto> getValidacionById(@PathVariable Integer id_usuario,@PathVariable Integer id_solicitud,@PathVariable Integer id_validacion) {
		return new ResponseEntity<>(serviceUsuario.getValidacionById(id_usuario, id_solicitud, id_validacion), HttpStatus.OK);
	}
	
	@DeleteMapping("/usuarios/{id_usuario}/solicitudes/{id_solicitud}/validaciones/{id_validacion}")
	public ResponseEntity<Void> deleteValidacionById(@PathVariable Integer id_usuario, @PathVariable Integer id_solicitud, @PathVariable Integer id_validacion) {
		serviceUsuario.deleteValidacionById(id_usuario, id_solicitud, id_validacion);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
