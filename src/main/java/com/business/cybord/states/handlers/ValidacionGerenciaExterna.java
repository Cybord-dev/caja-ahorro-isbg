package com.business.cybord.states.handlers;

import org.jeasy.states.api.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.business.cybord.states.events.ValidaGerenciaExternaEvent;
import com.business.cybord.states.events.ValidaGerenciaInternaEvent;

public class ValidacionGerenciaExterna implements EventHandler<ValidaGerenciaExternaEvent> {
	private static final Logger log = LoggerFactory.getLogger(ValidaGerenciaInternaEvent.class);

	public void handleEvent(ValidaGerenciaExternaEvent event) {
		log.info("Se realizo la validacion de Administracion");
		log.info(event.getSolicitudDto().toString());
	}

}