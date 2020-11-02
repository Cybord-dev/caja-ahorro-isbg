package com.business.cybord.services.executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.business.cybord.mappers.DatoUsuarioMapper;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.models.entities.AtributoSolicitud;
import com.business.cybord.models.entities.DatosUsuario;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.models.enums.EventFactoryTypeEnum;
import com.business.cybord.models.enums.TipoAtributoSolicitudEnum;
import com.business.cybord.models.enums.TipoAtributoUsuarioEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.services.DatoUsuarioService;
import com.business.cybord.services.MailService;

@Service
@Qualifier("ModificacionAhorroExecutor")
public class SolicitudModificacionAhorroExecutor implements SolicitudExecutor {

	@Autowired
	protected UsuariosRepository repositoryUsuario;

	@Autowired
	protected DatoUsuarioService datoUsuarioService;

	@Autowired
	protected DatoUsuarioMapper datoUsuarioMapper;

	@Autowired
	protected MailService mailService;

	@Override
	public void execute(SolicitudDto solicitudDto, ValidacionDto validacionDto) throws IsbgServiceException {
		Usuario usuario = repositoryUsuario.findById(solicitudDto.getIdUsuario())
				.orElseThrow(() -> new IsbgServiceException("Error actualizando daatos en solicitud ahorro",
						String.format("El usuario  %d no existe", solicitudDto.getIdUsuario()),
						HttpStatus.CONFLICT.value()));
		if (solicitudDto.getStatus().equals(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState())) {
			DatosUsuario dato = usuario.getDatosUsuario().stream()
					.filter(a -> a.getTipoDato().equals(TipoAtributoUsuarioEnum.AHORRO.name())).findFirst()
					.orElseThrow(() -> new IsbgServiceException("Error actualizando daatos en solicitud ahorro",
							String.format("El usuario  %d no tiene sueldo", solicitudDto.getIdUsuario()),
							HttpStatus.CONFLICT.value()));
			AtributoSolicitud atributo = solicitudDto.getAttributesAsList().stream()
					.filter(a -> a.getNombre().equals(TipoAtributoSolicitudEnum.MONTO.name())).findFirst()
					.orElseThrow(() -> new IsbgServiceException("Error actualizando daatos en solicitud ahorro",
							String.format("El usuario  %d no existe", solicitudDto.getIdUsuario()),
							HttpStatus.CONFLICT.value()));
			dato.setDato(atributo.getValor());
			datoUsuarioService.actualizarDatoUsuario(usuario.getId(), dato.getTipoDato(),
					datoUsuarioMapper.getDtoFromDatosusuarioEntity(dato));
			mailService.sentEmail(usuario.getEmail(),
					String.format("Notificacion de finalizacion de la solicitud:%s", solicitudDto.getTipo()),
					String.format("Hola %s,\n\nSe completo  tu solicitud con el folio %d del tipo %s por la cantidad %s \n\nSaludos.", usuario.getNombre(),
							solicitudDto.getId(), solicitudDto.getTipo(),atributo.getValor()));
		} else {
			mailService.sentEmail(usuario.getEmail(),
					String.format("Notificacion de autorizacion de la solicitud:%s", solicitudDto.getTipo()),
					String.format(
							"Hola %s,\n\nSe realizo la validacion numero  %d para tu solicitud con el folio:%d del tipo %s en el area %s \n\nSaludos.",
							usuario.getNombre(), validacionDto.getNumeroValidacion(),solicitudDto.getId(), solicitudDto.getTipo(),
							validacionDto.getArea()));
		}
	}

	@Override
	public void rechazo(SolicitudDto solicitudDto, ValidacionDto validacionDto) throws IsbgServiceException {
		Usuario usuario = repositoryUsuario.findById(solicitudDto.getIdUsuario())
				.orElseThrow(() -> new IsbgServiceException("Error actualizando daatos en solicitud ahorro",
						String.format("El usuario  %d no existe", solicitudDto.getIdUsuario()),
						HttpStatus.CONFLICT.value()));
		mailService.sentEmail(usuario.getEmail(),
				String.format("Notificacion de rechazo de la solicitud: %s ", solicitudDto.getTipo()),
				String.format(
						"Hola %s,\n\nNo se completo tu solicitud con el follio %d del tipo %s en el area %s por el motivo %s\n\nSaludos.",
						usuario.getNombre(), solicitudDto.getId(), solicitudDto.getTipo(), validacionDto.getArea(),
						validacionDto.getStatusDesc()));
	}

}