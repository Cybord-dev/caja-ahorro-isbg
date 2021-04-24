package com.business.cybord.models.enums;

import java.util.Optional;

public enum ExecutorManagerEnum {

	SOLICITUD_AHORRO_EXECUTOR("SolicitudAhorroExecutor","SolicitudAhorro"),
	CANCELACION_AHORRO_EXECUTOR("CancelacionAhorroExecutor","CancelacionAhorro"),
	MODIFICACION_AHORRO_EXECUTOR("ModificacionAhorroExecutor","ModificacionAhorro"),
	RETIRO_PARCIAL_AHORRO_EXECUTOR("RetiroParcialAhorroExecutor","RetiroParcialAhorro"),
	PRESTAMO_EXECUTOR("PrestamoExecutor","SolicitudPrestamo");

	private String qualifier;
	private String solicitud;

	private ExecutorManagerEnum(String qualifier,String solicitud) {
		this.qualifier = qualifier;
		this.solicitud=solicitud;
	}

	public String getQualifier() {
		return qualifier;
	}
	
	public String getSolicitud() {
		return solicitud;
	}

	public static Optional<ExecutorManagerEnum> findByQualifier(String solicitud) {
		for (ExecutorManagerEnum v : values()) {
			if (v.getSolicitud().equals(solicitud)) {
				return Optional.of(v);
			}
		}
		return Optional.empty();
	}

}
