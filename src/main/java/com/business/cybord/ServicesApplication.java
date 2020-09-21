package com.business.cybord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.business.cybord.validations.suites.SolicitudAhorroSuite;

@SpringBootApplication
public class ServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesApplication.class, args);
	}
	

	@Bean
	public SolicitudAhorroSuite getSolicitudAhorroSuite() {
		return new SolicitudAhorroSuite();
	}

}
