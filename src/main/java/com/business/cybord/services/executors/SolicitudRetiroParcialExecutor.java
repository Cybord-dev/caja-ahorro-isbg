package com.business.cybord.services.executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.services.MailService;

@Service
@Qualifier("RetiroParcialAhorroSuiteExecutor")
public class SolicitudRetiroParcialExecutor implements SolicitudExecutor {

	@Autowired
	private UsuariosRepository repositoryUsuario;

	@Autowired
	private MailService mailService;
	
	@Override
	public void execute(SolicitudDto solicitudDtos,ValidacionDto validacionDto) throws IsbgServiceException {
//		TODO Auto-generated method stub
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
