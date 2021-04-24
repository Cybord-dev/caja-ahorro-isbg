package com.business.cybord.models.enums;

import com.business.cybord.states.solicitudes.ISolicitud;
import com.business.cybord.states.solicitudes.SolicitudAhorroExterna;
import com.business.cybord.states.solicitudes.SolicitudAhorroInterna;
import com.business.cybord.states.solicitudes.SolicitudCancelacionAhorroExterno;
import com.business.cybord.states.solicitudes.SolicitudCancelacionAhorroInterno;
import com.business.cybord.states.solicitudes.SolicitudModificacionAhorroExterna;
import com.business.cybord.states.solicitudes.SolicitudModificacionAhorroInterna;
import com.business.cybord.states.solicitudes.SolicitudPrestamoExterno;
import com.business.cybord.states.solicitudes.SolicitudPrestamoInterno;
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
	SOLICITUD_MODIFICACION_AHORRO_INTERNO {

		@Override
		public SolicitudModificacionAhorroInterna getInstance() {
			return new SolicitudModificacionAhorroInterna();
		}

	},SOLICITUD_MODIFICACION_AHORRO_EXTERNO{

		@Override
		public SolicitudModificacionAhorroExterna getInstance() {
			return new SolicitudModificacionAhorroExterna();
		}

	},SOLICITUD_PRESTAMO_EXTERNO{

		@Override
		public SolicitudPrestamoExterno getInstance() {
			return new SolicitudPrestamoExterno();
		}

	},SOLICITUD_PRESTAMO_INTERNO{

		@Override
		public SolicitudPrestamoInterno getInstance() {
			return new SolicitudPrestamoInterno();
		}

	};

	public abstract ISolicitud getInstance();

	class SolicitudFactory {
		public ISolicitud Create(SolicitudFactoryEnum type) {
			return type.getInstance();
		}
	}

}
