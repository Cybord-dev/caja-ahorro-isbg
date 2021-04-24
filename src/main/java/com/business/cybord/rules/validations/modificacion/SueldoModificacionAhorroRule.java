package com.business.cybord.rules.validations.modificacion;

import java.math.BigDecimal;
import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.business.cybord.models.dtos.CapacidadPagoDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.UsuarioDto;
import com.business.cybord.models.enums.TipoAtributoSolicitudEnum;

@Rule(name = "SueldoModificacionAhorroRule", description = "Validacion del sueldo del usuario durante la modificacion de ahorro")
public class SueldoModificacionAhorroRule {

	@Condition
	public boolean condition(@Fact("solicitud") SolicitudDto solicitudDto, @Fact("usuario") UsuarioDto usuarioDto,
			@Fact("capacidad") CapacidadPagoDto capacidad, @Fact("results") List<String> results) {
		if (solicitudDto.getAtributos() != null && !solicitudDto.getAtributos().isEmpty()
				&& solicitudDto.getAtributos().containsKey(TipoAtributoSolicitudEnum.MONTO.name())) {
			BigDecimal monto = new BigDecimal(solicitudDto.getAtributos().get(TipoAtributoSolicitudEnum.MONTO.name()));
			return monto.compareTo(capacidad.getCapacidadPago().add(capacidad.getAhorro())) >= 1;
		}
		return true;
	}

	@Action
	public void execute(@Fact("results") List<String> results) {
		results.add("Tu capacidad de pago no es suficiente");
	}
}
