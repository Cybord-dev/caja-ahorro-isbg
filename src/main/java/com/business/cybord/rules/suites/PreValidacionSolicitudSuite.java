package com.business.cybord.rules.suites;

import org.jeasy.rules.api.Rules;

public class PreValidacionSolicitudSuite implements ValidacionSuite {

	private Rules rules = new Rules();

	public PreValidacionSolicitudSuite() {
	}

	@Override
	public Rules getSuite() {
		return rules;
	}

}
