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
import com.business.cybord.models.dtos.SaldoPrestamoDto;
import com.business.cybord.services.PrestamoService;

@RestController
@RequestMapping("/api/v1")
public class PrestamoController {

	@Autowired
	private PrestamoService service;

	@GetMapping("/usuarios/{idUsuario}/prestamos")
	public ResponseEntity<List<PrestamoDto>> getPrestamosByUsuario(@PathVariable Integer idUsuario) {
		return new ResponseEntity<>(service.getPrestamosdeUnUsuarioById(idUsuario), HttpStatus.OK);
	}

	@PostMapping("/usuarios/{idUsuario}/prestamos")
	public ResponseEntity<PrestamoDto> insertPrestamo(@PathVariable Integer idUsuario,
			@RequestBody @Valid PrestamoDto dto) {
		return new ResponseEntity<>(service.insertPrestamo(idUsuario, dto), HttpStatus.CREATED);
	}
	
	@GetMapping("/usuarios/{idUsuario}/prestamos/pendientes")
	public ResponseEntity<List<PrestamoDto>> getPrestamosByUsuariosPendientes(@PathVariable Integer idUsuario) {
		return new ResponseEntity<>(service.getPrestamosdeUnUsuarioByIdNotCompleted(idUsuario), HttpStatus.OK);
	}
	
	// TODO: ENDPOINT DE TODOS LOS SALDOS POR FILTROS GLOBALES
	/// prestamos

	@GetMapping("/usuarios/{idUsuario}/prestamos/{idPrestamo}/saldos/{idSaldo}")
	public ResponseEntity<PrestamoDto> getPrestamoPorIdPrestamoYIdusuarioYIdSaldo(@PathVariable Integer idUsuario,
			@PathVariable Integer idPrestamo, @PathVariable Integer idSaldo) {
		return new ResponseEntity<>(service.getPrestamoPorIdPrestamoYIdusuarioYIdSaldo(idUsuario, idPrestamo, idSaldo),
				HttpStatus.OK);
	}

	@PostMapping("/prestamos/generarsaldo")
	public ResponseEntity<List<SaldoPrestamoDto>> generarSaldo() {
		return new ResponseEntity<>(service.generarSaldoPrestamo(), HttpStatus.CREATED);

	}

	@PostMapping("/prestamos/{idPrestamo}/saldos")
	public ResponseEntity<SaldoPrestamoDto> insertPagoPrestamo(@PathVariable Integer idPrestamo,
			@RequestBody @Valid SaldoPrestamoDto saldo) {
		return new ResponseEntity<>(service.insertPagoPrestamo(idPrestamo, saldo), HttpStatus.CREATED);
	}

}
