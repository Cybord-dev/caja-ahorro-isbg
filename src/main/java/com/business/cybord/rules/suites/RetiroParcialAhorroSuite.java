package com.business.cybord.rules.suites;

import org.jeasy.rules.api.Rules;

import com.business.cybord.rules.validations.general.NoSoyAhorradorRule;

public class RetiroParcialAhorroSuite implements ISuite {

	private Rules rules = new Rules();

	public RetiroParcialAhorroSuite() {
		rules.register(new NoSoyAhorradorRule());
	}

	@Override
	public Rules getSuite() {
		return rules;
	}

}