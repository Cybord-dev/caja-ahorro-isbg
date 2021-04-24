package com.business.cybord.states.events;

import org.jeasy.states.api.AbstractEvent;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.enums.EventFactoryTypeEnum;

public class ValidaRhEvent extends AbstractEvent {
	private SolicitudDto solicitudDto;

	public ValidaRhEvent(SolicitudDto solicitudDto) {
		super(EventFactoryTypeEnum.VALIDA_RH.getState());
		this.solicitudDto = solicitudDto;
	}

	protected ValidaRhEvent(String name) {
		super(name);
	}

	public SolicitudDto getSolicitudDto() {
		return solicitudDto;
	}

	public void setSolicitudDto(SolicitudDto solicitudDto) {
		this.solicitudDto = solicitudDto;
	}

}