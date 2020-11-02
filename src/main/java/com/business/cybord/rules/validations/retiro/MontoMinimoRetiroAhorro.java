package com.business.cybord.rules.validations.retiro;

import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.UsuarioDto;
import com.business.cybord.models.enums.TipoAtributoEnum;

@Rule(name = "MontoMinimoRetiroAhorro", description = "Se valida el monto minimo de retiroo")
public class MontoMinimoRetiroAhorro {

	@Condition
	public boolean condition(@Fact("solicitud") SolicitudDto solicitudDto, @Fact("usuario") UsuarioDto usuarioDto,
			@Fact("results") List<String> results) {
		if (solicitudDto != null && solicitudDto.getAtributos() != null
				&& solicitudDto.getAtributos().containsKey(TipoAtributoEnum.MONTO.name())) {
			return Double.valueOf(solicitudDto.getAtributos().get(TipoAtributoEnum.MONTO.name())) <= 0.00;
		} else {
			return true;
		}
	}

	@Action
	public void execute(@Fact("results") List<String> results) {
		results.add("El monto de ahorro es menor al minimo");
	}

}
