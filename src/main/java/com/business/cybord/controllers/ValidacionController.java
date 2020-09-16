package com.business.cybord.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.services.ValidacionService;

@RestController
@RequestMapping("/validaciones")
public class ValidacionController {
	@Autowired
	ValidacionService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<ValidacionDto> getValidacionById(@PathVariable Integer id) {
		return new ResponseEntity<>(service.getValidacionById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteValidacionById(@PathVariable Integer id) {
		service.deleteValidacionById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
