package com.business.cybord.rules.validations.general;

import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.UsuarioDto;
import com.business.cybord.models.enums.TipoAtributoSolicitudEnum;

@Rule(name = "MontoModificacionAhorroRule", description = "Se valida el monto minimo de modificacion ahorro")
public class MontoModificacionAhorroRule {

	@Condition
	public boolean condition(@Fact("solicitud") SolicitudDto solicitudDto, @Fact("usuario") UsuarioDto usuarioDto,
			@Fact("results") List<String> results) {
		if (solicitudDto != null && solicitudDto.getAtributos() != null
				&& solicitudDto.getAtributos().containsKey(TipoAtributoSolicitudEnum.MONTO.name())) {
			return Double.valueOf(solicitudDto.getAtributos().get(TipoAtributoSolicitudEnum.MONTO.name())) <= 100.00;
		} else {
			return true;
		}
	}

	@Action
	public void execute(@Fact("results") List<String> results) {
		results.add("El monto de ahorro es menor al minimo");
	}

}
