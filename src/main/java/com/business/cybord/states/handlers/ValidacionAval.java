package com.business.cybord.states.handlers;

import org.jeasy.states.api.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.business.cybord.states.events.ValidaAvalesEvent;

public class ValidacionAval implements EventHandler<ValidaAvalesEvent> {

	private static final Logger log = LoggerFactory.getLogger(ValidacionRh.class);

    public void handleEvent(ValidaAvalesEvent event) {
    	log.info("Se realizo la validacion de contabildiad");
    }

}