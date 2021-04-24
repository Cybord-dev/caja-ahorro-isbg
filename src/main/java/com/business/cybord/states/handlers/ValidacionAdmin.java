package com.business.cybord.states.handlers;

import org.jeasy.states.api.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.business.cybord.states.events.ValidaAdminEvent;

public class ValidacionAdmin implements EventHandler<ValidaAdminEvent> {

	private static final Logger log = LoggerFactory.getLogger(ValidacionRh.class);

    public void handleEvent(ValidaAdminEvent event) {
    	log.info("Se realizo la validacion de Administracion");
    	log.info(event.getSolicitudDto().toString());
    }

}
