package com.business.cybord.rules.validations.ahorro;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.business.cybord.models.dtos.SolicitudDto;

@Rule(name = "FechaInicioAhorroRule", description = "Se valida la fecha minima de ahorro")
public class FechaInicioAhorroRule {

	@Condition
	public boolean condition(@Fact("solicitud") SolicitudDto solicitudDto,
			@Fact("results") List<String> results) {
		 LocalDate endDate =
		 LocalDate.now().withMonth(Month.NOVEMBER.getValue()).withDayOfMonth(1);
		 if (solicitudDto.getFechaEjecucion()
				.before(Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
			return false;
		}
		return false;
	}

	@Action
	public void execute(@Fact("results") List<String> results) {
		results.add("La fecha es posterior a la dlimitada por las reglas");
	}

}