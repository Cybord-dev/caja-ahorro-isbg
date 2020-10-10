package com.business.cybord.models.enums;

import com.business.cybord.states.solicitudes.ISolicitud;
import com.business.cybord.states.solicitudes.SolicitudAhorro;
import com.business.cybord.states.solicitudes.SolicitudCancelacionAhorro;
import com.business.cybord.states.solicitudes.SolicitudModificacionAhorro;
import com.business.cybord.states.solicitudes.SolicitudRetiroAnticipado;

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

	},
	SOLICITUD_RETIRO_PARCIAL_AHORRO {

		@Override
		public SolicitudRetiroAnticipado getInstance() {
			return new SolicitudRetiroAnticipado();
		}

	},
	SOLICITUD_MODIFICACION_AHORRO {

		@Override
		public SolicitudModificacionAhorro getInstance() {
			return new SolicitudModificacionAhorro();
		}

	},;

	public abstract ISolicitud getInstance();

	class SolicitudFactory {
		public ISolicitud Create(SolicitudFactoryEnum type) {
			return type.getInstance();
		}
	}

}
