package com.business.cybord.rules.suites;

import org.jeasy.rules.api.Rules;

public class RetiroParcialAhorroSuite implements ISuite {

	private Rules rules = new Rules();

	public RetiroParcialAhorroSuite() {
	}

	@Override
	public Rules getSuite() {
		return rules;
	}

}