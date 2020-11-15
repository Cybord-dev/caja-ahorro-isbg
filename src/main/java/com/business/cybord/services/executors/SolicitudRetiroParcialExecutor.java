package com.business.cybord.services.executors;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.business.cybord.models.config.FileConfig;
import com.business.cybord.models.dtos.SaldoAhorroDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionDto;
import com.business.cybord.models.entities.AtributoSolicitud;
import com.business.cybord.models.entities.DatosUsuario;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.models.enums.EventFactoryTypeEnum;
import com.business.cybord.models.enums.TipoAhorroEnum;
import com.business.cybord.models.enums.TipoAtributoSolicitudEnum;
import com.business.cybord.models.enums.TipoAtributoUsuarioEnum;
import com.business.cybord.models.enums.config.TipoArchivoEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.services.MailService;
import com.business.cybord.services.PdfServiceGenerator;
import com.business.cybord.services.SaldoAhorroService;
import com.business.cybord.utils.builder.SolicitudPdfModelDtoBuilder;

@Service
@Qualifier("RetiroParcialAhorroExecutor")
public class SolicitudRetiroParcialExecutor implements SolicitudExecutor {

	@Autowired
	protected UsuariosRepository repositoryUsuario;

	@Autowired
	protected SaldoAhorroService saldoAhorroService;

	@Autowired
	protected MailService mailService;

	@Autowired
	private PdfServiceGenerator pdfServiceGenerator;
	
	@Override
	public void execute(SolicitudDto solicitudDto, ValidacionDto validacionDto) throws IsbgServiceException {
		Usuario usuario = repositoryUsuario.findById(solicitudDto.getIdUsuario())
				.orElseThrow(() -> new IsbgServiceException("Error actualizando datos en solicitud ahorro",
						String.format("El usuario  %d no existe", solicitudDto.getIdUsuario()),
						HttpStatus.CONFLICT.value()));
		if (solicitudDto.getStatus().equals(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState())) {
			AtributoSolicitud monto = solicitudDto.getAttributesAsList().stream()
					.filter(a -> a.getNombre().equals(TipoAtributoSolicitudEnum.MONTO.name())).findFirst()
					.orElseThrow(() -> new IsbgServiceException("Error actualizando daatos en solicitud ahorro",
							String.format("El usuario  %d no existe", solicitudDto.getIdUsuario()),
							HttpStatus.CONFLICT.value()));
			saldoAhorroService.insertSadoAhorro(usuario.getId(),
					new SaldoAhorroDto(usuario.getId(), TipoAhorroEnum.RETIRO.getTipo(),
							new BigDecimal(monto.getValor()).multiply(new BigDecimal(-1)), true),"Sistema");
			Optional<DatosUsuario> oficina = usuario.getDatosUsuario().stream()
					.filter(a -> a.getTipoDato().equals(TipoAtributoUsuarioEnum.OFICINA.name())).findFirst();
			
			String texto = String.format(
					"%s, con número de trabajador %s , " + 
					"adscrito a la Oficina de %s solicito por este medio la cantidad de " + 
					"$%s por concepto de Retiro Parcial de mi ahorro.",
					usuario.getNombre(), usuario.getNoEmpleado(), oficina.isPresent() ? oficina.get().getDato() : "",
							monto.getValor());
			
			SolicitudPdfModelDtoBuilder modelBuilderDto = new SolicitudPdfModelDtoBuilder().setFecha(new Date())
					.setTitulo("Solicitud de Retiro Parcial del Programa de Ahorro Voluntario").setTexto(texto)
					.setNombre(usuario.getNombre());
			FileConfig fileConfig = new FileConfig(TipoArchivoEnum.PDF, "SolicitudRetiroParcialAhorro",
					pdfServiceGenerator.generateSolicitudesAhorroPdf(modelBuilderDto.build(), solicitudDto.getId()));
			mailService.sentEmail(usuario.getEmail(),
					String.format("Notificacion de finalizacion de la solicitud:%s", solicitudDto.getTipo()),
					String.format("Hola %s,\n\nSe completo  tu solicitud con el folio %d del tipo %s y el monto %s \n\nSaludos.", usuario.getNombre(),
							solicitudDto.getId(), solicitudDto.getTipo(),monto.getValor()),fileConfig);
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
