package com.business.cybord.validations.rules;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.business.cybord.models.dtos.SolicitudDto;

@Rule(name = "FechaInicioAhorroRule", description = "Se valida la fecha minia de ahorro")
public class FechaInicioAhorroRule {

	@Condition
	public boolean condition(@Fact("solicitud") SolicitudDto solicitudDto, @Fact("results") List<String> results) {
		LocalDate endDate = LocalDate.now();
		endDate= endDate.withMonth(Month.SEPTEMBER.getValue()).withDayOfMonth(1);
		if (LocalDate.now().isBefore(endDate)) {
				return false;
		}
		return true;
	}

	@Action
	public void execute(@Fact("results") List<String> results) {
		results.add("La fecha es posterior a la dlimitada por las reglas");
	}
	
	
}
