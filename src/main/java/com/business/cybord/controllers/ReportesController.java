package com.business.cybord.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.cybord.services.ReportesService;

@RestController
@RequestMapping("/api/v1/reportes")
public class ReportesController {

	@Autowired
	private ReportesService service;

	
}
