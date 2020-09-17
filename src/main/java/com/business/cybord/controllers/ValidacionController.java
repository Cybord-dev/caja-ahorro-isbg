package com.business.cybord.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.services.ValidacionService;

@RestController
@RequestMapping("/validaciones")
public class ValidacionController {
	@Autowired
	ValidacionService service;
	
	@GetMapping
	public ResponseEntity<List<ValidacionDto>> getValidacionById() {
		return new ResponseEntity<>(service.getAllValidaciones(), HttpStatus.OK);
	}

}
