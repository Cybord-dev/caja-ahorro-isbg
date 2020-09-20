package com.business.cybord.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.RecursoDto;
import com.business.cybord.services.RecursoService;
import com.business.cybord.error.InvoiceManagerException;

@RestController
@RequestMapping("/recursos")
public class RecursoController {
	
	@Autowired
	private RecursoService service;
	
	@GetMapping("/tipoRecurso/{tipoRecurso}/tipoArchivo/{tipoArchivo}/referencias/{referencia}")
	public ResponseEntity<RecursoDto> getRecursos(@PathVariable(name = "tipoRecurso") String tipoRecurso,
			@PathVariable(name = "tipoArchivo") String tipoArchivo, @PathVariable(name = "referencia") String referencia)
			throws InvoiceManagerException {
		return new ResponseEntity<>(service.getRecursoPorTipoRecursoYreferenciaYTipoArchivo(tipoRecurso, referencia, tipoArchivo),
				HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> insertarRecurso(@RequestBody @Valid RecursoDto recurso) {
		service.insertarRecurso(recurso);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarRecurso(@PathVariable Integer id) {
		service.borrarRecurso(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
