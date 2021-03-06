package com.business.cybord.utils.builder;

import java.math.BigDecimal;
import java.util.Date;

import com.business.cybord.models.entities.Prestamo;
import com.business.cybord.models.entities.Solicitud;

public class PrestamoBuilder extends AbstractBuilder<Prestamo> {

	public PrestamoBuilder() {
		super(new Prestamo());
	}

	public PrestamoBuilder setIdDeudor(int idDeudor) {
		instance.setIdDeudor(idDeudor);
		return this;
	}

	public PrestamoBuilder setEstatus(String estatus) {
		instance.setEstatus(estatus);
		return this;
	}

	public PrestamoBuilder setMonto(BigDecimal monto) {
		instance.setMonto(monto);
		return this;
	}

	public PrestamoBuilder setNoQuincenas(int noQuincenas) {
		instance.setNoQuincenas(noQuincenas);
		return this;
	}

	public PrestamoBuilder setSaldoPendiente(BigDecimal saldoPendiente) {
		instance.setSaldoPendiente(saldoPendiente);
		return this;
	}

	public PrestamoBuilder setFechaTerminacion(Date fechaTerminacion) {
		instance.setFechaTerminacion(fechaTerminacion);
		return this;
	}

	public PrestamoBuilder setSolicitud(Solicitud solicitud) {
		instance.setSolicitud(solicitud);
		return this;
	}
	
	public PrestamoBuilder setTasaInteres(BigDecimal tasaInteres) {
		instance.setTasaInteres(tasaInteres);
		return this;
	}

}
