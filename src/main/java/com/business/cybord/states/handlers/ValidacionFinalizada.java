package com.business.cybord.states.handlers;

import org.jeasy.states.api.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.business.cybord.states.events.SolicitudFinalizadaEvent;
import com.business.cybord.states.events.ValidaTesoEvent;

public class ValidacionFinalizada implements EventHandler<SolicitudFinalizadaEvent> {

	private static final Logger log = LoggerFactory.getLogger(ValidaTesoEvent.class);

    public void handleEvent(SolicitudFinalizadaEvent event) {
    	log.info("Se finalizo la solicitud");
    	log.info(event.getSolicitudDto().toString());
    }

}
