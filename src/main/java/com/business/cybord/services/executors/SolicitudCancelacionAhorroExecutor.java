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
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.models.enums.EventFactoryTypeEnum;
import com.business.cybord.models.enums.TipoAhorroEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.services.MailService;
import com.business.cybord.services.SaldoAhorroService;

@Service
@Qualifier("CancelacionAhorroExecutor")
public class SolicitudCancelacionAhorroExecutor implements SolicitudExecutor {

	@Autowired
	protected UsuariosRepository repositoryUsuario;

	@Autowired
	protected SaldoAhorroService saldoAhorroService;

	@Autowired
	protected MailService mailService;

	@Override
	public void execute(SolicitudDto solicitudDto, ValidacionDto validacionDto) throws IsbgServiceException {
		Usuario usuario = repositoryUsuario.findById(solicitudDto.getIdUsuario())
				.orElseThrow(() -> new IsbgServiceException("Error actualizando daatos en solicitud ahorro",
						String.format("El usuario  %d no existe", solicitudDto.getIdUsuario()),
						HttpStatus.CONFLICT.value()));

		if (solicitudDto.getStatus().equals(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState())) {
			List<SaldoAhorroDto> ahorros = saldoAhorroService.getSaldosAhorroByUsuario(usuario.getId());
			BigDecimal ahorro = new BigDecimal(0);
			for (SaldoAhorroDto a : ahorros) {
				ahorro = ahorro.add(a.getMonto());
			}
			saldoAhorroService.insertSadoAhorro(usuario.getId(), new SaldoAhorroDto(usuario.getId(),
					TipoAhorroEnum.RETIRO.getTipo(), ahorro.multiply(new BigDecimal(-1)), true));
			usuario.setAhorrador(false);
			repositoryUsuario.save(usuario);
			mailService.sentEmail(usuario.getEmail(),
					String.format("Notificacion de finalizacion de la solicitud:%s", solicitudDto.getTipo()),
					String.format("Hola %s,\nSe completo  tu solicitud numero:%d del tipo %s y tu retiro de  %.2f", usuario.getNombre(),
							solicitudDto.getId(), solicitudDto.getTipo(),ahorro));
		} else {
			mailService.sentEmail(usuario.getEmail(),
					String.format("Notificacion de autorizacion de la solicitud:%s", solicitudDto.getTipo()),
					String.format(
							"Hola %s,\nSe realizo la validacion para tu solicitud numero:%d del tipo %s en el area %s",
							usuario.getNombre(), solicitudDto.getId(), solicitudDto.getTipo(),
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
						"Hola %s,\nNo se completo tu solicitud numero:%d del tipo %s en el area %s por el motivo %s",
						usuario.getNombre(), solicitudDto.getId(), solicitudDto.getTipo(), validacionDto.getArea(),
						solicitudDto.getStatusDetalle()));
	}
}
