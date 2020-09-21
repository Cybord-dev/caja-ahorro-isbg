package com.business.cybord.validations.suites;

import org.jeasy.rules.api.Rules;

public class CancelacionAhorroSuite implements ISuite {

	private Rules rules = new Rules();

	public CancelacionAhorroSuite() {
	}

	@Override
	public Rules getSuite() {
		return rules;
	}
}
