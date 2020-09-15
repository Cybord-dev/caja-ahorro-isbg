package com.business.cybord.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.business.cybord.models.dtos.DatosUsuarioDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.UsuariosDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.services.UsuariosService;


@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuariosService service;

	@GetMapping("/{id}")
	public ResponseEntity<UsuariosDto> getUserById(@PathVariable Integer id) {
		return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<UsuariosDto>> getAllFacturasByParametros(@RequestParam Map<String, String> parameters) {
		return new ResponseEntity<>(service.getUsuariosPorParametros(parameters), HttpStatus.OK);
	}
	
	@PostMapping("/{id}/solicitudes")
	public ResponseEntity<SolicitudDto> crearSolicitudUsuario(@PathVariable Integer id, @RequestBody @Valid SolicitudDto solicitudDto) {
		return new ResponseEntity<>(service.crearSolicitudUsuario(id, solicitudDto), HttpStatus.OK);
	}
	
	@PutMapping("{id}/solicitudes/{id_solicitud}")
	public ResponseEntity<SolicitudDto> actualizarSolicitudbyId(@PathVariable Integer id, @PathVariable Integer id_solicitud, @RequestBody @Valid SolicitudDto solicitudDto) {
		return new ResponseEntity<>(service.actualizarSolicitudbyId(id, id_solicitud, solicitudDto), HttpStatus.OK);
	}
	
	@PostMapping("/{id}/validaciones")
	public ResponseEntity<ValidacionDto> crearValidacionesUsuario(@PathVariable Integer id, @RequestBody @Valid ValidacionDto validacionDto) {
		return new ResponseEntity<>(service.crearValidacion(id, validacionDto), HttpStatus.OK);
	}
	
	@PutMapping("/{id}/validaciones/{id_validacion}")
	public ResponseEntity<ValidacionDto> actualizarSolicitudbyId(@PathVariable Integer id, @PathVariable Integer id_validacion, @RequestBody @Valid ValidacionDto validacionDto) {
		return new ResponseEntity<>(service.actualizarValidacionById(id, id_validacion, validacionDto), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<UsuariosDto> NewUsuarios(@RequestBody @Valid UsuariosDto usuarioDto) {
		return new ResponseEntity<>(service.insertarNuevoUsuario(usuarioDto), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<UsuariosDto> updateUser(@RequestBody @Valid UsuariosDto userDto) {
		return new ResponseEntity<>(service.actualizarUsuario(userDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarUsuario(@PathVariable Integer id) {
		service.borrarUsuario(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/datos")
	public ResponseEntity<DatosUsuarioDto> setinsertarNuevoDatoUsuario(@RequestBody @Valid DatosUsuarioDto datousuarioDto) {
		return new ResponseEntity<>(service.insertarNuevoDatoUsuario(datousuarioDto), HttpStatus.OK);
	}
	
	@PutMapping("/datos")
	public ResponseEntity<DatosUsuarioDto> setactualizarDatoUsuario(@RequestBody @Valid DatosUsuarioDto datousuarioDto) {
		return new ResponseEntity<>(service.actualizarDatoUsuario(datousuarioDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/datos/{id}")
	public ResponseEntity<Void> setborrarDatoUsuario(@PathVariable Integer id) {
		service.borraDatoUsuario(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
