package com.business.cybord.rules.validations.general;

import java.math.BigDecimal;
import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.business.cybord.models.dtos.CapacidadPagoDto;
import com.business.cybord.models.dtos.SolicitudDto;

@Rule(name = "SueldoAhorroRule", description = "Validacion del sueldo del usuario")
public class SueldoAhorroRule {

	@Condition
	public boolean condition(@Fact("solicitud") SolicitudDto solicitudDto,
			@Fact("capacidad") CapacidadPagoDto capacidad, @Fact("results") List<String> results) {
		if (solicitudDto.getAtributos() != null && !solicitudDto.getAtributos().isEmpty()
				&& solicitudDto.getAtributos().containsKey("MONTO")) {
			BigDecimal monto = new BigDecimal(solicitudDto.getAtributos().get("MONTO"));
			return monto.compareTo(capacidad.getCapacidadPago()) >= 1;
		}
		return true;
	}

	@Action
	public void execute(@Fact("results") List<String> results) {
		results.add("Tu capacidad de pago no es suficiente");
	}

}
