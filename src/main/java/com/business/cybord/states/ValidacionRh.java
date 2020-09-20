package com.business.cybord.states;

import org.jeasy.states.api.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.business.cybord.states.events.ValidaRhEvent;

public class ValidacionRh  implements EventHandler<ValidaRhEvent> {

	private static final Logger log = LoggerFactory.getLogger(ValidacionRh.class);
	
    public void handleEvent(ValidaRhEvent event) {
    	log.info("Se realizo la validacion de recursos humanos");
    	log.info(event.getSolicitudDto().toString());
    }

}
