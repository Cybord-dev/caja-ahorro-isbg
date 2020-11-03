package com.business.cybord.states.events;

import org.jeasy.states.api.AbstractEvent;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.enums.EventFactoryTypeEnum;

public class ValidaDireccionEvent extends AbstractEvent {
	private SolicitudDto solicitudDto;

	public ValidaDireccionEvent(SolicitudDto solicitudDto) {
		super(EventFactoryTypeEnum.VALIDA_DIRECCION.getState());
		this.solicitudDto = solicitudDto;
	}


	public SolicitudDto getSolicitudDto() {
		return solicitudDto;
	}

	public void setSolicitudDto(SolicitudDto solicitudDto) {
		this.solicitudDto = solicitudDto;
	}

}
