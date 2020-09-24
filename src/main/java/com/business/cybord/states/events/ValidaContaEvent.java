package com.business.cybord.states.events;

import org.jeasy.states.api.AbstractEvent;

import com.business.cybord.models.dtos.SolicitudDto;

public class ValidaContaEvent extends AbstractEvent {

	private SolicitudDto solicitudDto;

    public ValidaContaEvent(SolicitudDto solicitudDto) {
        super("ValidaContaEvent");
        this.solicitudDto=solicitudDto;
    }

    protected ValidaContaEvent(String name) {
        super(name);
    }

	public SolicitudDto getSolicitudDto() {
		return solicitudDto;
	}

	public void setSolicitudDto(SolicitudDto solicitudDto) {
		this.solicitudDto = solicitudDto;
	}

}