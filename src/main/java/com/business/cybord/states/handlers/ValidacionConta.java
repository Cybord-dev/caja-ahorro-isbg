package com.business.cybord.states.handlers;

import org.jeasy.states.api.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.business.cybord.states.events.ValidaContaEvent;

public class ValidacionConta implements EventHandler<ValidaContaEvent> {

	private static final Logger log = LoggerFactory.getLogger(ValidacionRh.class);

    public void handleEvent(ValidaContaEvent event) {
    	log.info("Se realizo la validacion de contabildiad");
    }

}
