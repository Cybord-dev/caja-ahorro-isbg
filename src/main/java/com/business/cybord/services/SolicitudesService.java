package com.business.cybord.services;

import org.jeasy.states.api.FiniteStateMachineException;
import org.springframework.stereotype.Service;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.enums.SolicitudFactoryEnum;
import com.business.cybord.models.enums.SolicitudFactoryTypeEnum;
import com.business.cybord.states.events.ValidaRhEvent;
import com.business.cybord.states.solicitudes.ISolicitud;

@Service
public class SolicitudesService {

	public SolicitudDto validarSolicitud(SolicitudDto solicitudDto) throws FiniteStateMachineException {
//		SolicitudFactoryEnum sfte = SolicitudFactoryTypeEnum.findByReferenceName(solicitudDto.getTipoSolicitud())
//				.getEnumValue();
//		ISolicitud solicitud = sfte.getInstance();
//		solicitud.define(solicitudDto.getStatus());
//		solicitud.fire(new ValidaRhEvent(solicitudDto));
//		solicitudDto.setStatus(solicitudDto.getCurrentValidation());
		return solicitudDto;
	}
}
