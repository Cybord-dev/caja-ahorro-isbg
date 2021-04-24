package com.business.cybord.states.handlers;

import org.jeasy.states.api.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.business.cybord.states.events.ValidaGerenciaInternaEvent;

public class ValidacionGerenciaInterna implements EventHandler<ValidaGerenciaInternaEvent> {
	private static final Logger log = LoggerFactory.getLogger(ValidaGerenciaInternaEvent.class);

	public void handleEvent(ValidaGerenciaInternaEvent event) {
		log.info("Se realizo la validacion de Administracion");
		log.info(event.getSolicitudDto().toString());
	}

}