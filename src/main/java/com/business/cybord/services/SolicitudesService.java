package com.business.cybord.services;

import java.util.ArrayList;
import java.util.List;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.states.api.FiniteStateMachineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.enums.SolicitudFactoryEnum;
import com.business.cybord.models.enums.SolicitudFactoryTypeEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.states.events.ValidaRhEvent;
import com.business.cybord.states.solicitudes.ISolicitud;
import com.business.cybord.validations.commons.SuiteManager;
import com.business.cybord.validations.suites.ISuite;

@Service
public class SolicitudesService {

	@Autowired
	private SuiteManager suiteManager;

	@Autowired
	protected RulesEngine rulesEngine;

	public SolicitudDto validarSolicitud(SolicitudDto solicitudDto)
			throws FiniteStateMachineException, IsbgServiceException {
		SolicitudFactoryEnum sfte = SolicitudFactoryTypeEnum.findByReferenceName(solicitudDto.getTipo()).getEnumValue();
		executeRules(solicitudDto);
		ISolicitud solicitud = sfte.getInstance();
		solicitud.define(solicitudDto.getStatus());
		solicitud.fire(new ValidaRhEvent(solicitudDto));
		solicitudDto.setStatus(solicitudDto.getStatus());
		return solicitudDto;
	}

	private void executeRules(SolicitudDto solicitudDto) throws IsbgServiceException {
		ISuite suite = suiteManager.getSolicitudSuite(solicitudDto.getTipo());
		Facts facts = new Facts();
		List<String> results = new ArrayList<>();
		facts.put("solicitud", solicitudDto);
		facts.put("results", results);
		rulesEngine.fire(suite.getSuite(), facts);
		if (!results.isEmpty()) {
			throw new IsbgServiceException(results.toString(), "errores durante la validacion de la solicitud.");
		}
	}
}
