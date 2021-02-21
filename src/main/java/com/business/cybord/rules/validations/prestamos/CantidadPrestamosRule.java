package com.business.cybord.rules.validations.prestamos;

import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.business.cybord.models.Constants;
import com.business.cybord.models.dtos.CapacidadPagoDto;

@Rule(name = "CantidadPrestamosRule", description = "Se valida la cantidad maxima de prestamos")
public class CantidadPrestamosRule {

	
	@Condition
	public boolean condition(
			@Fact("capacidad") CapacidadPagoDto capacidad, @Fact("results") List<String> results) {
		return capacidad.getPrestamosActivos().size()+1>Constants.CTD_MAX_PRESTAMOS;
	}

	@Action
	public void execute(@Fact("results") List<String> results) {
		results.add("El usuario ya tiene 3 prestamos");
	}
	
}
