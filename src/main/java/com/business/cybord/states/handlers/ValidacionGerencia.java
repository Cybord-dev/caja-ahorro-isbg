package com.business.cybord.states.handlers;

import org.jeasy.states.api.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.business.cybord.states.events.ValidaGerenciaEvent;

public class ValidacionGerencia implements EventHandler<ValidaGerenciaEvent> {
	private static final Logger log = LoggerFactory.getLogger(ValidaGerenciaEvent.class);

	public void handleEvent(ValidaGerenciaEvent event) {
		log.info("Se realizo la validacion de Administracion");
		log.info(event.getSolicitudDto().toString());
	}

}
