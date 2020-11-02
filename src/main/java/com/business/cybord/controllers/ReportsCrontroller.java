/**
 * 
 */
package com.business.cybord.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.business.cybord.services.UsuarioService;

/**
 * @author Ralph
 *
 */
@Controller
public class ReportsCrontroller {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value = "/api/v1/usuarios/report", method = RequestMethod.GET)
	public ResponseEntity<Object> getUsuarioSReportByParametros(@RequestParam Map<String, String> parameters,HttpServletResponse response) throws IOException {
		service.descargaReporteUsuarios(parameters, response);
		return null;
	}

}
