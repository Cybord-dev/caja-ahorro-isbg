package com.business.cybord.rules.suites;

import org.jeasy.rules.api.Rules;

import com.business.cybord.rules.validations.prestamos.CantidadPrestamosRule;
import com.business.cybord.rules.validations.prestamos.PrestamoCapacidadPagoRule;

public class SolicitudPrestamoSuite implements ISuite {
	
	private Rules rules = new Rules();
	
	public SolicitudPrestamoSuite() {
		rules.register(new CantidadPrestamosRule());
		rules.register(new PrestamoCapacidadPagoRule());
	}

	@Override
	public Rules getSuite() {
		return rules;
	}

}
