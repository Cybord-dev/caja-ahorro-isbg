package com.business.cybord.rules.suites;

import org.jeasy.rules.api.Rules;

import com.business.cybord.rules.validations.general.NoSoyAhorradorRule;

public class CancelacionAhorroSuite implements ISuite {

	private Rules rules = new Rules();

	public CancelacionAhorroSuite() {
		rules.register(new NoSoyAhorradorRule());
	}

	@Override
	public Rules getSuite() {
		return rules;
	}
}