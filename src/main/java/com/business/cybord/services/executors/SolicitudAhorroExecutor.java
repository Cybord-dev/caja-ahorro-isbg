package com.business.cybord.services.executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.models.enums.EventFactoryTypeEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.services.MailService;

@Service
@Qualifier("SolicitudAhorroExecutor")
public class SolicitudAhorroExecutor implements SolicitudExecutor {

	@Autowired
	private UsuariosRepository repositoryUsuario;

	@Autowired
	private MailService mailService;

	@Override
	public void execute(SolicitudDto solicitudDto, ValidacionDto validacionDto) throws IsbgServiceException {
		Usuario usuario = repositoryUsuario.findById(solicitudDto.getIdUsuario())
				.orElseThrow(() -> new IsbgServiceException("Error actualizando daatos en solicitud ahorro",
						String.format("El usuario  %d no existe", solicitudDto.getIdUsuario()),
						HttpStatus.CONFLICT.value()));
		if (solicitudDto.getStatus().equals(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState())) {
			usuario.setAhorrador(true);
			repositoryUsuario.save(usuario);
			mailService.sentEmail(usuario.getEmail(),
					String.format("Notificacion de finalizacion de la solicitud:%s", solicitudDto.getTipo()),
					String.format("Se completo la solicitud %s ", solicitudDto.getTipo()));
		} else {
			mailService.sentEmail(usuario.getEmail(),
					String.format("Notificacion de autorizacion de la solicitud:%s", solicitudDto.getTipo()),
					String.format("Se realizo la validacion no %d para la solicitud %s del area %s",
							validacionDto.getNumeroValidacion(), solicitudDto.getTipo(), validacionDto.getArea()));
		}
	}

	@Override
	public void rechazo(SolicitudDto solicitudDto, ValidacionDto validacionDto) throws IsbgServiceException {
		Usuario usuario = repositoryUsuario.findById(solicitudDto.getIdUsuario())
				.orElseThrow(() -> new IsbgServiceException("Error actualizando daatos en solicitud ahorro",
						String.format("El usuario  %d no existe", solicitudDto.getIdUsuario()),
						HttpStatus.CONFLICT.value()));
		mailService.sentEmail(usuario.getEmail(),
				String.format("Notificacion de rechazo de la solicitud:%s", solicitudDto.getTipo()),
				String.format("No se completo la solicitud solicitud %s en el area %s", solicitudDto.getTipo(),
						validacionDto.getArea()));
	}

}
