package com.business.cybord.models.enums;

import com.business.cybord.states.solicitudes.ISolicitud;
import com.business.cybord.states.solicitudes.SolicitudAhorroExterna;
import com.business.cybord.states.solicitudes.SolicitudAhorroInterna;
import com.business.cybord.states.solicitudes.SolicitudCancelacionAhorroExterno;
import com.business.cybord.states.solicitudes.SolicitudCancelacionAhorroInterno;
import com.business.cybord.states.solicitudes.SolicitudModificacionAhorro;
import com.business.cybord.states.solicitudes.SolicitudRetiroAnticipadoExterno;
import com.business.cybord.states.solicitudes.SolicitudRetiroAnticipadoInterno;

public enum SolicitudFactoryEnum {

	SOLICITUD_AHORRO_INTERNO {

		@Override
		public SolicitudAhorroInterna getInstance() {
			return new SolicitudAhorroInterna();
		}

	},
	SOLICITUD_AHORRO_EXTERNO {

		@Override
		public SolicitudAhorroExterna getInstance() {
			return new SolicitudAhorroExterna();
		}

	},
	SOLICITUD_CANCELACION_AHORRO_INTERNO {

		@Override
		public SolicitudCancelacionAhorroInterno getInstance() {
			return new SolicitudCancelacionAhorroInterno();
		}

	},
	SOLICITUD_CANCELACION_AHORRO_EXTERNO {

		@Override
		public SolicitudCancelacionAhorroExterno getInstance() {
			return new SolicitudCancelacionAhorroExterno();
		}

	},
	SOLICITUD_RETIRO_PARCIAL_AHORRO_INTERNO {

		@Override
		public SolicitudRetiroAnticipadoInterno getInstance() {
			return new SolicitudRetiroAnticipadoInterno();
		}

	},
	SOLICITUD_RETIRO_PARCIAL_AHORRO_EXTERNO {

		@Override
		public SolicitudRetiroAnticipadoExterno getInstance() {
			return new SolicitudRetiroAnticipadoExterno();
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
