package com.business.cybord.models.enums;

import com.business.cybord.states.solicitudes.ISolicitud;
import com.business.cybord.states.solicitudes.SolicitudAhorro;
import com.business.cybord.states.solicitudes.SolicitudCancelacionAhorro;

public enum SolicitudFactoryEnum {

	SOLICITUD_AHORRO {

		@Override
		public SolicitudAhorro getInstance() {
			return new SolicitudAhorro();
		}

	},
	SOLICITUD_CANCELACION_AHORRO {

		@Override
		public SolicitudCancelacionAhorro getInstance() {
			return new SolicitudCancelacionAhorro();
		}

	};

	public abstract ISolicitud getInstance();

	class SolicitudFactory {
		public ISolicitud Create(SolicitudFactoryEnum type) {
			return type.getInstance();
		}
	}

}
