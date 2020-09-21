package com.business.cybord.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.SaldoAhorroDto;
import com.business.cybord.services.SaldoAhorroService;

@RestController
@RequestMapping("/usuarios")
public class SaldosAhorroController {

	@Autowired
	private SaldoAhorroService service;

	@GetMapping("/{idUsuario}/ahorros")
	public ResponseEntity<List<SaldoAhorroDto>> getSaldosAhorroDeUnUsuarioPorSuId(@PathVariable Integer idUsuario) {
		return new ResponseEntity<>(service.getSaldosAhorroDeUnUsuarioPorSuId(idUsuario), HttpStatus.OK);
	}

	@PostMapping("/{idUsuario}/ahorros")
	public ResponseEntity<SaldoAhorroDto> insertSadoAhorro(@PathVariable Integer idUsuario,
			@RequestBody @Valid SaldoAhorroDto Dto) {
		return new ResponseEntity<>(service.insertSadoAhorro(idUsuario, Dto), HttpStatus.CREATED);
	}

	@GetMapping("/{idUsuario}/ahorros/{idAhorro}")
	public ResponseEntity<SaldoAhorroDto> getSaldoAhorroPorIdYIdusuario(@PathVariable Integer idUsuario,
			@PathVariable Integer idAhorro) {
		return new ResponseEntity<>(service.getSaldoAhorroPorIdYIdusuario(idUsuario, idAhorro), HttpStatus.OK);
	}

}
