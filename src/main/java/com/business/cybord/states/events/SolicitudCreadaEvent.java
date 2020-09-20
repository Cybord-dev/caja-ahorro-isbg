package com.business.cybord.states.events;

import org.jeasy.states.api.AbstractEvent;

public class SolicitudCreadaEvent extends AbstractEvent {

    public SolicitudCreadaEvent() {
        super("SolicitudCreadaEvent");
    }

    protected SolicitudCreadaEvent(String name) {
        super(name);
    }

}
