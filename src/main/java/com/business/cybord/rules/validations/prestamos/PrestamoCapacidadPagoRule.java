package com.business.cybord.rules.validations.prestamos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.business.cybord.models.dtos.CapacidadPagoDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.enums.TipoAtributoSolicitudEnum;

@Rule(name = "PrestamoCapacidadPagoRule", description = "Validacion de si puedo pedir prestamo dependiendo mi capacidad de pago")
public class PrestamoCapacidadPagoRule {

	@Condition
	public boolean condition(@Fact("solicitud") SolicitudDto solicitudDto,
			@Fact("capacidad") CapacidadPagoDto capacidad, @Fact("results") List<String> results) {
		if (solicitudDto.getAtributos() != null && !solicitudDto.getAtributos().isEmpty()
				&& solicitudDto.getAtributos().containsKey(TipoAtributoSolicitudEnum.MONTO.name())) {
			BigDecimal monto = new BigDecimal(solicitudDto.getAtributos().get(TipoAtributoSolicitudEnum.MONTO.name()));
			BigDecimal quincenas = new BigDecimal(solicitudDto.getAtributos().get(TipoAtributoSolicitudEnum.NO_QUINCENAS.name()));
			return monto.divide(quincenas, 2, RoundingMode.FLOOR).compareTo(capacidad.getCapacidadPago()) >= 1;
		}
		return true;
	}

	@Action
	public void execute(@Fact("results") List<String> results) {
		results.add("Tu capacidad de pago no es suficiente");
	}

}
