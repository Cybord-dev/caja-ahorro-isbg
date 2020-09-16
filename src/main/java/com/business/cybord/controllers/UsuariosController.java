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

import com.business.cybord.models.dtos.AtributoSolicitudDto;
import com.business.cybord.models.dtos.DatosUsuarioDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.UsuariosDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.services.UsuariosService;
import com.business.cybord.services.ValidacionService;


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
	
	/**Solicitudes**/
	@PostMapping("/{id_usuario}/solicitudes")
	public ResponseEntity<SolicitudDto> crearSolicitudUsuario(@PathVariable Integer id_usuario, @RequestBody @Valid SolicitudDto solicitudDto) {
		return new ResponseEntity<>(service.crearSolicitudUsuario(id_usuario, solicitudDto), HttpStatus.OK);
	}
	
	@PutMapping("/{id_usuario}/solicitudes/{id_solicitud}")
	public ResponseEntity<SolicitudDto> actualizarSolicitudbyId(@PathVariable Integer id_usuario, @PathVariable Integer id_solicitud, @RequestBody @Valid SolicitudDto solicitudDto) {
		return new ResponseEntity<>(service.actualizarSolicitudbyId(id_usuario, id_solicitud, solicitudDto), HttpStatus.OK);
	}
	
	@GetMapping("/{id_usuario}/solicitudes/{id_solicitud}")
	public ResponseEntity<SolicitudDto> getSolicitudById(@PathVariable Integer id_usuario, @PathVariable Integer id_solicitud) {
		return new ResponseEntity<>(service.getSolicitudById(id_usuario,id_solicitud), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_usuario}/solicitudes/{id_solicitud}")
	public ResponseEntity<Void> deleteSolicitudById(@PathVariable Integer id_usuario, @PathVariable Integer id_solicitud) {
		service.deleteSolicitudById(id_usuario, id_solicitud);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/*Validaciones*/
	@PostMapping("/{id_usuario}/solicitudes/{id_solicitud}/validaciones")
	public ResponseEntity<ValidacionDto> crearValidacionesUsuario(@PathVariable Integer id_usuario,@PathVariable Integer id_solicitud ,@RequestBody @Valid ValidacionDto validacionDto) {
		return new ResponseEntity<>(service.crearValidacion(id_usuario,id_solicitud, validacionDto), HttpStatus.OK);
	}
	
	
	@PutMapping("/{id_usuario}/solicitudes/{id_solicitud}/validaciones/{id_validacion}")
	public ResponseEntity<ValidacionDto> actualizarValidacionbyId(@PathVariable Integer id_usuario,@PathVariable Integer id_solicitud,@PathVariable Integer id_validacion, @RequestBody @Valid ValidacionDto validacionDto) {
		return new ResponseEntity<>(service.actualizarValidacionById(id_usuario, id_solicitud,id_validacion,validacionDto), HttpStatus.OK);
	}
	
	@GetMapping("/{id_usuario}/solicitudes/{id_solicitud}/validaciones/{id_validacion}")
	public ResponseEntity<ValidacionDto> getValidacionById(@PathVariable Integer id_usuario,@PathVariable Integer id_solicitud,@PathVariable Integer id_validacion) {
		return new ResponseEntity<>(service.getValidacionById(id_usuario, id_solicitud, id_validacion), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_usuario}/solicitudes/{id_solicitud}/validaciones/{id_validacion}")
	public ResponseEntity<Void> deleteValidacionById(@PathVariable Integer id_usuario, @PathVariable Integer id_solicitud, @PathVariable Integer id_validacion) {
		service.deleteValidacionById(id_usuario, id_solicitud, id_validacion);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/*Atributos-Solicitud*/
	
	@PostMapping("/{id_usuario}/solicitudes/{id_solicitud}/atributos")
	public ResponseEntity<AtributoSolicitudDto> crearAtributoById(@PathVariable Integer id_usuario,@PathVariable Integer id_solicitud, @RequestBody @Valid AtributoSolicitudDto atributo) {
		return new ResponseEntity<>(service.createAtributoSolicitud(id_usuario, id_solicitud, atributo), HttpStatus.OK);
	}
	
	@PutMapping("/{id_usuario}/solicitudes/{id_solicitud}/atributos/{id_atributo}")
	public ResponseEntity<AtributoSolicitudDto> actualizarAtributoById(@PathVariable Integer id_usuario, @PathVariable Integer id_solicitud,@PathVariable Integer id_atributo,  @RequestBody @Valid AtributoSolicitudDto atributo) {
		return new ResponseEntity<>(service.actualizarAtributoSolicitud(id_usuario, id_solicitud, id_atributo, atributo), HttpStatus.OK);
	}
	
	@GetMapping("/{id_usuario}/solicitudes/{id_solicitud}/atributos/{id_atributo}")
	public ResponseEntity<AtributoSolicitudDto> getAtributoSolicitudById(@PathVariable Integer id_usuario, @PathVariable Integer id_solicitud,@PathVariable Integer id_atributo) {
		return new ResponseEntity<>(service.getAtributoSolicitudById(id_usuario, id_solicitud, id_atributo), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_usuario}/solicitudes/{id_solicitud}/atributos/{id_atributo}")
	public ResponseEntity<Void> deleteAtributoSolicitudById(@PathVariable Integer id_usuario, @PathVariable Integer id_solicitud,@PathVariable Integer id_atributo) {
		service.deleteAtributoSolicitudById(id_usuario, id_solicitud, id_atributo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
