package com.business.cybord.controllers;

import java.io.IOException;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.CapacidadPagoDto;
import com.business.cybord.models.dtos.RecursoDto;
import com.business.cybord.models.dtos.UserInfoDto;
import com.business.cybord.models.dtos.UsuarioDto;
import com.business.cybord.models.dtos.composed.UserAhorroDto;
import com.business.cybord.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {

	@Autowired
	private UsuarioService service;

	@GetMapping("/myInfo")
	public ResponseEntity<UserInfoDto> getMyInfo(Authentication authentication) {
		return new ResponseEntity<>(service.getUserInfo(authentication), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> getUserById(@PathVariable Integer id) {
		return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
	}
	
	@GetMapping("/{noEmpleado}/capacidad-pago")
	public ResponseEntity<CapacidadPagoDto> getcapacidadPagoUserById(@PathVariable String noEmpleado) {
		return new ResponseEntity<>(service.calculoCapacidadPago(noEmpleado), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Page<UserAhorroDto>> getAllUsuariosByParametros(
			@RequestParam Map<String, String> parameters) {
		return new ResponseEntity<>(service.getAllUsuarios(parameters), HttpStatus.OK);
	}

	@GetMapping("/report")
	public ResponseEntity<RecursoDto> getUsuariosReportByParametros(@RequestParam Map<String, String> parameters)
			throws IOException {
		return new ResponseEntity<>(service.descargaReporteUsuarios(parameters), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UsuarioDto> insertarNuevoUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
		return new ResponseEntity<>(service.insertarNuevoUsuario(usuarioDto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDto> actualizarUsuario(@RequestBody @Valid UsuarioDto userDto,
			@PathVariable Integer id) {
		return new ResponseEntity<>(service.actualizarUsuario(userDto, id), HttpStatus.OK);
	}

}
