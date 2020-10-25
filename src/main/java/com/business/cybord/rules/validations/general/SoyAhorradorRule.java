package com.business.cybord.rules.validations.general;

import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.UsuarioDto;

@Rule(name = "SoyAhorradorRule", description = "Se valida si el usuario ya es ahorrador")
public class SoyAhorradorRule {

	@Condition
	public boolean condition(@Fact("solicitud") SolicitudDto solicitudDto, @Fact("usuario") UsuarioDto usuarioDto,
			@Fact("results") List<String> results) {
		return usuarioDto.isAhorrador();
	}

	@Action
	public void execute(@Fact("results") List<String> results) {
		results.add("El usuario ya es ahorrador");
	}

}
