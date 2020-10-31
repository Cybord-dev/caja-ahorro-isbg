package com.business.cybord.controllers;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.SaldoAhorroDto;
import com.business.cybord.models.dtos.composed.ReporteSaldosDto;
import com.business.cybord.models.dtos.composed.SaldoAhorroCajaDto;
import com.business.cybord.services.SaldoAhorroService;

@RestController
@RequestMapping("/api/v1")
public class SaldosAhorroController {

	@Autowired
	private SaldoAhorroService service;

	@GetMapping("/saldosAhorro")
	public ResponseEntity<Page<ReporteSaldosDto>> getSaldosAhorrosCurrentCaja(
			@RequestParam Map<String, String> parameters) {
		return new ResponseEntity<>(service.getSaldosAhorrosCurrentCaja(parameters), HttpStatus.OK);
	}

	@GetMapping("/saldosAhorro/anual")
	public ResponseEntity<List<SaldoAhorroCajaDto>> getSaldosAhorrosCurrentCajaAnual() {
		return new ResponseEntity<>(service.getSaldosAhorrosCurrentCajaAnual(), HttpStatus.OK);
	}
	
	@GetMapping("/saldosAhorro/anual/agrupado")
	public ResponseEntity<List<SaldoAhorroCajaDto>> getSaldosAhorrosCurrentCajaAnualAgrupado() {
		return new ResponseEntity<>(service.getSaldosAhorrosCurrentCajaAnualAgrupado(), HttpStatus.OK);
	}

	@GetMapping("/usuarios/{idUsuario}/ahorros")
	public ResponseEntity<List<SaldoAhorroDto>> getSaldosAhorroDeUnUsuarioPorSuId(@PathVariable Integer idUsuario) {
		return new ResponseEntity<>(service.getSaldosAhorroByUsuario(idUsuario), HttpStatus.OK);
	}

	@PostMapping("/usuarios/{idUsuario}/ahorros")
	public ResponseEntity<SaldoAhorroDto> insertSadoAhorro(@PathVariable Integer idUsuario,
			@RequestBody @Valid SaldoAhorroDto dto) {
		return new ResponseEntity<>(service.insertSadoAhorro(idUsuario, dto), HttpStatus.CREATED);
	}

	@GetMapping("/usuarios/{idUsuario}/ahorros/{idAhorro}")
	public ResponseEntity<SaldoAhorroDto> getSaldoAhorroPorIdYIdusuario(@PathVariable Integer idUsuario,
			@PathVariable Integer idAhorro) {
		return new ResponseEntity<>(service.getSaldoAhorroByIdAndIdUsuario(idUsuario, idAhorro), HttpStatus.OK);
	}

	@PostMapping("/ahorros/bulk")
	public ResponseEntity<List<SaldoAhorroDto>> inserrtBulk(@RequestBody @Valid List<SaldoAhorroDto> dtos,
			Authentication authentication) {
		return new ResponseEntity<>(service.insertBulk(dtos, authentication), HttpStatus.CREATED);
	}

}
