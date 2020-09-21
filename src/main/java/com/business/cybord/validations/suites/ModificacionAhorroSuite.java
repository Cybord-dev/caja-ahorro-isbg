package com.business.cybord.validations.suites;

import org.jeasy.rules.api.Rules;

public class ModificacionAhorroSuite implements ISuite {

	private Rules rules = new Rules();

	public ModificacionAhorroSuite() {
	}

	@Override
	public Rules getSuite() {
		return rules;
	}

}
