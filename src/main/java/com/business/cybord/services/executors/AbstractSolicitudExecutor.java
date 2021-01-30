package com.business.cybord.services.executors;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.business.cybord.models.entities.AtributoSolicitud;
import com.business.cybord.models.enums.TipoAtributoSolicitudEnum;
import com.business.cybord.models.error.IsbgServiceException;

public class AbstractSolicitudExecutor {

	protected AtributoSolicitud getAttributeFromList(TipoAtributoSolicitudEnum tipoAttribute,
			List<AtributoSolicitud> atributos) throws IsbgServiceException {
		return atributos.stream().filter(a -> a.getNombre().equals(tipoAttribute.name())).findFirst()
				.orElseThrow(() -> new IsbgServiceException("No existe el monto en la solicitud",
						"No existe el monto en la solicitud", HttpStatus.CONFLICT.value()));
	}
}
