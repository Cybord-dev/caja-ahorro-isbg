package com.business.cybord.services.executors;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.models.enums.EventFactoryTypeEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.UsuariosRepository;

@Service
@Qualifier("SolicitudAhorroExecutor")
public class SolicitudAhorroExecutor implements SolicitudExecutor {

	@Autowired
	private UsuariosRepository repositoryUsuario;

	@Override
	public SolicitudDto execute(SolicitudDto solicitudDto) throws IsbgServiceException {
		if (solicitudDto.getStatus().equals(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState())) {
			Optional<Usuario> usuario = repositoryUsuario.findById(solicitudDto.getIdUsuario());
			if (usuario.isPresent()) {
				usuario.get().setAhorrador(true);
				repositoryUsuario.save(usuario.get());
			} else {
				throw new IsbgServiceException("Error actualizando daatos en solicitud ahorro",
						String.format("El usuario  %d no existe", solicitudDto.getIdUsuario()),
						HttpStatus.CONFLICT.value());
			}
		}
		return solicitudDto;
	}

}
