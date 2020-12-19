/**
 * 
 */
package com.business.cybord.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ralfdemoledor
 *
 */
@RestController
public class UtilController {
	
	
	@GetMapping("/health")
	public String health() {
		return "OK";
	}
	
	@GetMapping("/exit")
	public String logout() {
		return "Redirigiendo fuera de la app";
	}

}
