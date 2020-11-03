package com.business.cybord.services.executors;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.business.cybord.models.dtos.SaldoAhorroDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.models.entities.DatosUsuario;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.models.enums.EventFactoryTypeEnum;
import com.business.cybord.models.enums.TipoAhorroEnum;
import com.business.cybord.models.enums.TipoAtributoUsuarioEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.services.DatoUsuarioService;
import com.business.cybord.services.MailService;
import com.business.cybord.services.SaldoAhorroService;

@Service
@Qualifier("CancelacionAhorroExecutor")
public class SolicitudCancelacionAhorroExecutor implements SolicitudExecutor {

	@Autowired
	protected UsuariosRepository repositoryUsuario;
	
	@Autowired
	protected DatoUsuarioService datoUsuarioService;

	@Autowired
	protected SaldoAhorroService saldoAhorroService;

	@Autowired
	protected MailService mailService;

	@Override
	public void execute(SolicitudDto solicitudDto, ValidacionDto validacionDto) throws IsbgServiceException {
		Usuario usuario = repositoryUsuario.findById(solicitudDto.getIdUsuario())
				.orElseThrow(() -> new IsbgServiceException("Error actualizando datos en solicitud ahorro",
						String.format("El usuario  %d no existe", solicitudDto.getIdUsuario()),
						HttpStatus.CONFLICT.value()));

		if (solicitudDto.getStatus().equals(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState())) {
			DatosUsuario dato = usuario.getDatosUsuario().stream()
					.filter(a -> a.getTipoDato().equals(TipoAtributoUsuarioEnum.AHORRO.name())).findFirst()
					.orElseThrow(() -> new IsbgServiceException("Error actualizando daatos en solicitud ahorro",
							String.format("El usuario  %d no tiene sueldo", solicitudDto.getIdUsuario()),
							HttpStatus.CONFLICT.value()));
			List<SaldoAhorroDto> ahorros = saldoAhorroService.getSaldosAhorroByUsuario(usuario.getId());
			BigDecimal ahorro = new BigDecimal(0);
			for (SaldoAhorroDto a : ahorros) {
				ahorro = ahorro.add(a.getMonto());
			}
			saldoAhorroService.insertSadoAhorro(usuario.getId(), new SaldoAhorroDto(usuario.getId(),
					TipoAhorroEnum.RETIRO.getTipo(), ahorro.multiply(new BigDecimal(-1)), true));
			usuario.setAhorrador(false);
			repositoryUsuario.save(usuario);
			datoUsuarioService.borraDatoUsuario(dato.getId());
			mailService.sentEmail(usuario.getEmail(),
					String.format("Notificacion de finalizacion de la solicitud:%s", solicitudDto.getTipo()),
					String.format("Hola %s,\n\nSe completo  tu solicitud con el folio %d del tipo %s y tu retiro de  %.2f \n\nSaludos.", usuario.getNombre(),
							solicitudDto.getId(), solicitudDto.getTipo(),ahorro));
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
