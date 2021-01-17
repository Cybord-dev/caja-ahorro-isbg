package com.business.cybord.rules.suites;

import org.jeasy.rules.api.Rules;

public class SolicitudPrestamoSuite implements ISuite {
	
	private Rules rules = new Rules();

	@Override
	public Rules getSuite() {
		return rules;
	}

}
