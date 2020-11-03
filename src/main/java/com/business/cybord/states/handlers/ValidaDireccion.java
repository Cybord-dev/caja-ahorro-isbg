package com.business.cybord.states.handlers;

import org.jeasy.states.api.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.business.cybord.states.events.ValidaDireccionEvent;

public class ValidaDireccion implements EventHandler<ValidaDireccionEvent> {
	private static final Logger log = LoggerFactory.getLogger(ValidaDireccionEvent.class);

	public void handleEvent(ValidaDireccionEvent event) {
		log.info("Se realizo la validacion de Administracion");
		log.info(event.getSolicitudDto().toString());
	}

}
