package com.business.cybord.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.models.dtos.CatCajaDto;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.services.CajaUtilityService;

@RestController
@RequestMapping("/api/v1")
public class CajaUtilityController {

	@Autowired
	private CajaUtilityService service;

	@GetMapping("/caja")
	public ResponseEntity<CatCajaDto> getCutrentCaja() throws IsbgServiceException {
		return new ResponseEntity<>(service.getCurrentCaja(), HttpStatus.OK);
	}

}