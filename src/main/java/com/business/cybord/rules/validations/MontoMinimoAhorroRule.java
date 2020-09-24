package com.business.cybord.rules.validations;

import java.util.List;
import java.util.Optional;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.business.cybord.models.dtos.AtributoSolicitudDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.enums.TipoAtributoEnum;

@Rule(name = "MontoMinimoAhorroRule", description = "Se valida el monto minimo de ahorro")
public class MontoMinimoAhorroRule {

	@Condition
	public boolean condition(@Fact("solicitud") SolicitudDto solicitudDto, @Fact("results") List<String> results) {
		if (solicitudDto != null && solicitudDto.getAtributos() != null && !solicitudDto.getAtributos().isEmpty()) {
			Optional<AtributoSolicitudDto> atributo = solicitudDto.getAtributos().stream()
					.filter(a -> a.getNombre().equals(TipoAtributoEnum.MONTO.name())).findFirst();
			if(atributo.isPresent()&&Double.parseDouble(atributo.get().getValor())>=100.0){
				return false;
			}
		}
		return true;
	}

	@Action
	public void execute(@Fact("results") List<String> results) {
		results.add("El monto de ahorro es menor al minimo");
	}

}