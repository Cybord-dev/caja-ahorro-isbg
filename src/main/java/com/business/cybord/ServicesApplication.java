package com.business.cybord;

import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.beans.factory.annotation.Qualifier;
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
	@Qualifier("SolicitudAhorro")
	public SolicitudAhorroSuite getSolicitudAhorroSuite() {
		return new SolicitudAhorroSuite();
	}
	
	@Bean
	public RulesEngine getRulesEngine() {
		return new DefaultRulesEngine();
	}


}
