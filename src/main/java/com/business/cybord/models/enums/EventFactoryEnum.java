package com.business.cybord.models.enums;

import org.jeasy.states.api.AbstractEvent;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.states.events.SolicitudCreadaEvent;
import com.business.cybord.states.events.SolicitudFinalizadaEvent;
import com.business.cybord.states.events.ValidaAdminEvent;
import com.business.cybord.states.events.ValidaContaEvent;
import com.business.cybord.states.events.ValidaDireccionEvent;
import com.business.cybord.states.events.ValidaGerenciaExternaEvent;
import com.business.cybord.states.events.ValidaGerenciaInternaEvent;
import com.business.cybord.states.events.ValidaRhEvent;
import com.business.cybord.states.events.ValidaTesoEvent;
import com.business.cybord.states.solicitudes.ISolicitud;

public enum EventFactoryEnum {

	SOLICITUD_CREADA {
		@Override
		public AbstractEvent getInstance(SolicitudDto dto) {
			return new SolicitudCreadaEvent(dto);
		}

	},
	VALIDA_RH_EVENT {

		@Override
		public AbstractEvent getInstance(SolicitudDto dto) {
			return new ValidaRhEvent(dto);
		}

	},
	VALIDA_CONTA_EVENT {

		@Override
		public AbstractEvent getInstance(SolicitudDto dto) {
			return new ValidaContaEvent(dto);
		}

	},
	VALIDA_TESO_EVENT {

		@Override
		public AbstractEvent getInstance(SolicitudDto dto) {
			return new ValidaTesoEvent(dto);
		}

	},
	VALIDA_ADMIN_EVENT {

		@Override
		public AbstractEvent getInstance(SolicitudDto dto) {
			return new ValidaAdminEvent(dto);
		}

	},
	VALIDA_GERENCIA_EXTERNA_EVENT {

		@Override
		public AbstractEvent getInstance(SolicitudDto dto) {
			return new ValidaGerenciaExternaEvent(dto);
		}

	},
	VALIDA_GERENCIA_INTERNA_EVENT {

		@Override
		public AbstractEvent getInstance(SolicitudDto dto) {
			return new ValidaGerenciaInternaEvent(dto);
		}

	},
	VALIDA_DIRECCION_EVENT {

		@Override
		public AbstractEvent getInstance(SolicitudDto dto) {
			return new ValidaDireccionEvent(dto);
		}

	},
	SOLICITUD_TERMINADA {

		@Override
		public AbstractEvent getInstance(SolicitudDto dto) {
			return new SolicitudFinalizadaEvent(dto);
		}

	};
	

	public abstract AbstractEvent getInstance(SolicitudDto dto);

	class SolicitudFactory {
		public ISolicitud Create(SolicitudFactoryEnum type) {
			return type.getInstance();
		}
	}

}
