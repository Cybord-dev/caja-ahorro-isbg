package com.business.cybord.rules.validations.modificacion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.UsuarioDto;
import com.business.cybord.models.enums.TipoAtributoSolicitudEnum;
import com.business.cybord.models.enums.TipoAtributoUsuarioEnum;

@Rule(name = "SueldoModificacionAhorroRule", description = "Validacion del sueldo del usuario durante la modificacion de ahorro")
public class SueldoModificacionAhorroRule {

	@Condition
	public boolean condition(@Fact("solicitud") SolicitudDto solicitudDto, @Fact("usuario") UsuarioDto usuarioDto,
			@Fact("results") List<String> results) {
		if (usuarioDto.getDatosUsuario() != null && !usuarioDto.getDatosUsuario().isEmpty()
				&& usuarioDto.getDatosUsuario().containsKey(TipoAtributoUsuarioEnum.SUELDO.name())
				&& solicitudDto.getAtributos() != null && !solicitudDto.getAtributos().isEmpty()
				&& solicitudDto.getAtributos().containsKey(TipoAtributoSolicitudEnum.MONTO.name())) {
			BigDecimal sueldo = new BigDecimal(usuarioDto.getDatosUsuario().get(TipoAtributoUsuarioEnum.SUELDO.name()));
			BigDecimal monto = new BigDecimal(
					solicitudDto.getAtributos().get(TipoAtributoSolicitudEnum.MONTO.name()));
			return monto.compareTo(
					sueldo.divide(new BigDecimal(2)).multiply(new BigDecimal(.7)).setScale(0, RoundingMode.UP)) == 1;
		}
		return true;
	}

	@Action
	public void execute(@Fact("results") List<String> results) {
		results.add("El usuario no cumple con los valores de sueldo");
	}
}
