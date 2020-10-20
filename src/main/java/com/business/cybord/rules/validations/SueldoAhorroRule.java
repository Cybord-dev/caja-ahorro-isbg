package com.business.cybord.rules.validations;

import java.math.BigDecimal;
import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.UsuarioDto;

@Rule(name = "SueldoAhorroRule", description = "Validacion del sueldo del usuario")
public class SueldoAhorroRule {

	@Condition
	public boolean condition(@Fact("solicitud") SolicitudDto solicitudDto, @Fact("usuario") UsuarioDto usuarioDto,
			@Fact("results") List<String> results) {
		if (usuarioDto.getDatosUsuario() != null && !usuarioDto.getDatosUsuario().isEmpty()
				&& usuarioDto.getDatosUsuario().containsKey("SUELDO") && solicitudDto.getAtributos() != null
				&& !solicitudDto.getAtributos().isEmpty() && solicitudDto.getAtributos().containsKey("MONTO")) {
			BigDecimal sueldo = new BigDecimal(usuarioDto.getDatosUsuario().get("SUELDO"));
			BigDecimal monto = new BigDecimal(solicitudDto.getAtributos().get("MONTO"));
			return monto.multiply(new BigDecimal(2)).compareTo(sueldo)==1;
		}
		return true;
	}

	@Action
	public void execute(@Fact("results") List<String> results) {
		results.add("El usurio no cumple con los valores de sueldo");
	}

}
