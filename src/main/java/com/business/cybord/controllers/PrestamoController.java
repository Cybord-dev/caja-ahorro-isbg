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

import com.business.cybord.models.dtos.PrestamoDto;
import com.business.cybord.services.PrestamoService;

@RestController
@RequestMapping("/usuarios")
public class PrestamoController {

	@Autowired
	private PrestamoService service;

	@GetMapping("/{idUsuario}/prestamos")
	public ResponseEntity<List<PrestamoDto>> getPrestamosByUsuario(@PathVariable Integer idUsuario) {
		return new ResponseEntity<>(service.getPrestamosdeUnUsuarioPorSuId(idUsuario), HttpStatus.OK);
	}

	@PostMapping("/{idUsuario}/prestamos")
	public ResponseEntity<PrestamoDto> insertPrestamo(@PathVariable Integer idUsuario,
			@RequestBody @Valid PrestamoDto Dto) {
		return new ResponseEntity<>(service.insertPrestamo(idUsuario, Dto), HttpStatus.CREATED);
	}

	@GetMapping("/{idUsuario}/prestamos/{idPrestamo}/saldos/{idSaldo}")
	public ResponseEntity<PrestamoDto> getPrestamoPorIdPrestamoYIdusuarioYIdSaldo(@PathVariable Integer idUsuario,
			@PathVariable Integer idPrestamo, @PathVariable Integer idSaldo) {
		return new ResponseEntity<>(service.getPrestamoPorIdPrestamoYIdusuarioYIdSaldo(idUsuario, idPrestamo, idSaldo),
				HttpStatus.OK);
	}

}
