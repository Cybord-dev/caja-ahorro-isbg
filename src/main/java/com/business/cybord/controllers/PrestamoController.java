package com.business.cybord.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.PrestamoDto;
import com.business.cybord.models.dtos.RecursoDto;
import com.business.cybord.models.dtos.SaldoPrestamoDto;
import com.business.cybord.services.PrestamoService;

@RestController
@RequestMapping("/api/v1")
public class PrestamoController {

	@Autowired
	private PrestamoService service;
	
	@GetMapping("/prestamos")
	public ResponseEntity<Page<PrestamoDto>> findAllAvalesByFiltros(
			@RequestParam Map<String, String> parameters) {
		return new ResponseEntity<>(service.findPrestamosByFiltros(parameters), HttpStatus.OK);
	}

	@GetMapping("/usuarios/{idUsuario}/prestamos")
	public ResponseEntity<List<PrestamoDto>> getPrestamosByUsuario(@PathVariable Integer idUsuario) {
		return new ResponseEntity<>(service.getPrestamosByUsuarioId(idUsuario), HttpStatus.OK);
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
	

	@GetMapping("/usuarios/{idUsuario}/prestamos/{idPrestamo}/saldos/{idSaldo}")
	public ResponseEntity<PrestamoDto> getPrestamoPorIdPrestamoYIdusuarioYIdSaldo(@PathVariable Integer idUsuario,
			@PathVariable Integer idPrestamo, @PathVariable Integer idSaldo) {
		return new ResponseEntity<>(service.getPrestamoByIdPrestamoAndIdusuarioAndIdSaldo(idUsuario, idPrestamo, idSaldo),
				HttpStatus.OK);
	}

	@PostMapping("/prestamos/generar-saldo")
	public ResponseEntity<List<SaldoPrestamoDto>> generarSaldo() {
		return new ResponseEntity<>(service.generarSaldoPrestamo(), HttpStatus.CREATED);

	}
	
	@GetMapping("/saldo-prestamos")
	public ResponseEntity<Page<SaldoPrestamoDto>> getPrestamosyParams(@RequestParam Map<String, String> parameters){
		return new ResponseEntity<>(service.getPrestamosyParams(parameters), HttpStatus.OK);	
	}
	
	@GetMapping("/saldo-prestamos/report")
	public ResponseEntity<RecursoDto> getPrestamosReportParams(@RequestParam Map<String, String> parameters) throws IOException{
		return new ResponseEntity<>(service.getPrestamosReportParams(parameters), HttpStatus.OK);	
	}

	@PostMapping("/prestamos/{idPrestamo}/saldos")
	public ResponseEntity<SaldoPrestamoDto> insertPagoPrestamo(@PathVariable Integer idPrestamo,
			@RequestBody @Valid SaldoPrestamoDto saldo) {
		return new ResponseEntity<>(service.insertPagoPrestamo(idPrestamo, saldo), HttpStatus.CREATED);
	}
	
	@PutMapping("/saldo-prestamos/{idSaldo}")
	public ResponseEntity<SaldoPrestamoDto> updatePagoPrestamo(@PathVariable Integer idSaldo,
			@RequestBody @Valid SaldoPrestamoDto saldo) {
		return new ResponseEntity<>(service.updatePagoPrestamo(idSaldo, saldo), HttpStatus.OK);
	}

	
	@PostMapping("/prestamos/{idPrestamo}/traspasar-prestamo")
	public ResponseEntity<List<PrestamoDto>> traspasarPrestamo(@PathVariable Integer idPrestamo){
		return new ResponseEntity<>(service.traspasarPrestamo(idPrestamo), HttpStatus.CREATED);
	}

}
