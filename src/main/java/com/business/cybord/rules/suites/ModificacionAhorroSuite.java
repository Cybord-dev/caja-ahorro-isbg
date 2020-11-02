package com.business.cybord.rules.suites;

import org.jeasy.rules.api.Rules;

import com.business.cybord.rules.validations.ahorro.FechaInicioAhorroRule;
import com.business.cybord.rules.validations.general.NoSoyAhorradorRule;
import com.business.cybord.rules.validations.modificacion.MontoModificacionAhorroRule;
import com.business.cybord.rules.validations.modificacion.SueldoModificacionAhorroRule;

public class ModificacionAhorroSuite implements ISuite {

	private Rules rules = new Rules();

	public ModificacionAhorroSuite() {
		rules.register(new MontoModificacionAhorroRule());
		rules.register(new FechaInicioAhorroRule());
		rules.register(new NoSoyAhorradorRule());
		rules.register(new SueldoModificacionAhorroRule());
	}

	@Override
	public Rules getSuite() {
		return rules;
	}

}