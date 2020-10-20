package com.business.cybord.rules.suites;

import org.jeasy.rules.api.Rules;

import com.business.cybord.rules.validations.FechaInicioAhorroRule;
import com.business.cybord.rules.validations.MontoMinimoAhorroRule;
import com.business.cybord.rules.validations.SoyAhorradorRule;
import com.business.cybord.rules.validations.SueldoAhorroRule;

public class SolicitudAhorroSuite implements ISuite {

	private Rules rules = new Rules();

	public SolicitudAhorroSuite() {
		rules.register(new MontoMinimoAhorroRule());
		rules.register(new FechaInicioAhorroRule());
		rules.register(new SoyAhorradorRule());
		rules.register(new SueldoAhorroRule());
	}

	@Override
	public Rules getSuite() {
		return rules;
	}

}