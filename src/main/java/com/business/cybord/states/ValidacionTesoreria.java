package com.business.cybord.states;

import org.jeasy.states.api.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.business.cybord.states.events.ValidaTesoEvent;


public class ValidacionTesoreria implements EventHandler<ValidaTesoEvent> {

	private static final Logger log = LoggerFactory.getLogger(ValidaTesoEvent.class);

    public void handleEvent(ValidaTesoEvent event) {
    	log.info("Se realizo la validacion de Tesorria");
    	log.info(event.getSolicitudDto().toString());
    }

}
