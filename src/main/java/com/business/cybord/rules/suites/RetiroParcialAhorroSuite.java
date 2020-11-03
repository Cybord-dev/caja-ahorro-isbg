package com.business.cybord.rules.suites;

import org.jeasy.rules.api.Rules;

import com.business.cybord.rules.validations.general.NoSoyAhorradorRule;
import com.business.cybord.rules.validations.retiro.MontoMinimoRetiroAhorro;

public class RetiroParcialAhorroSuite implements ISuite {

	private Rules rules = new Rules();

	public RetiroParcialAhorroSuite() {
		rules.register(new NoSoyAhorradorRule());
		rules.register(new MontoMinimoRetiroAhorro());
	}

	@Override
	public Rules getSuite() {
		return rules;
	}

}