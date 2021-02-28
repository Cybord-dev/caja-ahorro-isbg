package com.business.cybord.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.reports.ReporteAhorroDto;
import com.business.cybord.services.ReportesService;

@RestController
@RequestMapping("/api/v1/reportes")
public class ReportesController {

	@Autowired
	private ReportesService service;

	@GetMapping("/ahorros")
	public ResponseEntity<Page<ReporteAhorroDto>> findAllAvalesByFiltros(@RequestParam Map<String, String> parameters) {
		return new ResponseEntity<>(service.getPagedReporteAhorroByFiltros(parameters), HttpStatus.OK);
	}
}
