package com.business.cybord.utils.builder;

import java.math.BigDecimal;

import com.business.cybord.models.entities.InteresGeneradoLog;

public class InteresGeneradoLogBuilder extends AbstractBuilder<InteresGeneradoLog> {

	public InteresGeneradoLogBuilder() {
		super(new InteresGeneradoLog());
	}
	
	public InteresGeneradoLogBuilder setTipoUsuario(String tipoUsuario) {
		instance.setTipoUsuario(tipoUsuario);
		return this;
	}
	
	public InteresGeneradoLogBuilder setSaldoAhorro(BigDecimal saldoAhorro) {
		instance.setSaldoAhorro(saldoAhorro);
		return this;
	}
	
	public InteresGeneradoLogBuilder setInteresGenerado(BigDecimal interesGenerado) {
		instance.setInteresGenerado(interesGenerado);
		return this;
	}
	
	public InteresGeneradoLogBuilder setPorcentajeInteres(BigDecimal porcentajeInteres) {
		instance.setPorcentajeInteres(porcentajeInteres);
		return this;
	}
	
	public InteresGeneradoLogBuilder setInteresRepartido(BigDecimal interesRepartido) {
		instance.setInteresRepartido(interesRepartido);
		return this;
	}
	
	public InteresGeneradoLogBuilder setInteresCaja(BigDecimal interesCaja) {
		instance.setInteresCaja(interesCaja);
		return this;
	}
	
	
	
	
	
	
}
