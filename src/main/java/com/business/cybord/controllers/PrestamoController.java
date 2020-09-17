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
import com.business.cybord.models.dtos.SaldoAhorroDto;
import com.business.cybord.services.PrestamoService;
import com.business.cybord.services.SaldoAhorroService;

@RestController
@RequestMapping("prestamo/usuarios/")
public class PrestamoController {
	
	
	@Autowired
	private PrestamoService service;
	
	@GetMapping("/{idUsuario}/prestamo")
	public ResponseEntity<List<PrestamoDto>> getPrestamosdeUnUsuarioPorSuId(@PathVariable Integer idUsuario) {
		return new ResponseEntity<>(service.getPrestamosdeUnUsuarioPorSuId(idUsuario), HttpStatus.OK);
	}
	
	@PostMapping("/{idUsuario}")
	public ResponseEntity<PrestamoDto> insertPrestamo(@PathVariable Integer idUsuario,@RequestBody @Valid PrestamoDto Dto) {
		return new ResponseEntity<>(service.insertPrestamo(idUsuario,Dto), HttpStatus.OK);
	}
	
	@GetMapping("/{idUsuario}/prestamo/{idPrestamo}/saldos/{idSaldo}")
	public ResponseEntity<PrestamoDto> getPrestamoPorIdPrestamoYIdusuarioYIdSaldo(@PathVariable Integer idUsuario,@PathVariable Integer idPrestamo ,@PathVariable Integer idSaldo) {
		return new ResponseEntity<>(service.getPrestamoPorIdPrestamoYIdusuarioYIdSaldo(idUsuario,idPrestamo,idSaldo), HttpStatus.OK);
	}

}
