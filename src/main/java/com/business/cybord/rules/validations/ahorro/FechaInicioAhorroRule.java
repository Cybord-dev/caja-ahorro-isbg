package com.business.cybord.rules.validations.ahorro;

import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.UsuarioDto;

@Rule(name = "FechaInicioAhorroRule", description = "Se valida la fecha minima de ahorro")
public class FechaInicioAhorroRule {

	@Condition
	public boolean condition(@Fact("solicitud") SolicitudDto solicitudDto, @Fact("usuario") UsuarioDto usuarioDto,
			@Fact("results") List<String> results) {
		// LocalDate endDate =
		// LocalDate.now().withMonth(Month.SEPTEMBER.getValue()).withDayOfMonth(1);
		// TODO uncomment this rule when the code was ready on production
		// if (solicitudDto.getFechaEjecucion()
//				.before(Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
//			return false;
//		}
		return false;
	}

	@Action
	public void execute(@Fact("results") List<String> results) {
		results.add("La fecha es posterior a la dlimitada por las reglas");
	}

}