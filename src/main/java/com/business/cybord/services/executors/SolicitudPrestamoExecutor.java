package com.business.cybord.services.executors;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.Constants;
import com.business.cybord.models.config.FileConfig;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionSolicitudDto;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.models.enums.EstatusPrestamoEnum;
import com.business.cybord.models.enums.EventFactoryTypeEnum;
import com.business.cybord.models.enums.TipoAtributoSolicitudEnum;
import com.business.cybord.models.enums.config.TipoArchivoEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.PrestamoRepository;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.services.MailService;
import com.business.cybord.services.PdfServiceGenerator;
import com.business.cybord.utils.builder.PrestamoBuilder;
import com.business.cybord.utils.builder.SolicitudPdfModelDtoBuilder;

@Service
@Qualifier("PrestamoExecutor")
public class SolicitudPrestamoExecutor extends AbstractSolicitudExecutor implements SolicitudExecutor {

	@Autowired
	private UsuariosRepository repositoryUsuario;

	@Autowired
	private PrestamoRepository prestamoRepository;
	
	@Autowired
	private SolicitudMapper solicitudMapper;
	
	@Autowired
	private MailService mailService;

	@Autowired
	private PdfServiceGenerator pdfServiceGenerator;

	@Override
	public void execute(SolicitudDto solicitudDto, ValidacionSolicitudDto validacionDto) throws IsbgServiceException {
		Usuario usuario = repositoryUsuario.findById(solicitudDto.getIdUsuario())
				.orElseThrow(() -> new IsbgServiceException("Error actualizando datos en solicitud ahorro",
						String.format("El usuario  %d no existe", solicitudDto.getIdUsuario()),
						HttpStatus.CONFLICT.value()));
		
		if (solicitudDto.getStatus().equals(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState())) {
			// TODO: AGREGAR LA FECHA FINAL SUMANDO FECHA DE EJECUCION + NUMERO DE QUINCENAS
			BigDecimal Monto =new BigDecimal(
					getAttributeFromList(TipoAtributoSolicitudEnum.MONTO, solicitudDto.getAttributesAsList())
							.getValor());
			PrestamoBuilder prestamoBuilder = new PrestamoBuilder().setEstatus(EstatusPrestamoEnum.ACTIVO.name())
					.setFechaTerminacion(new Date()).setIdDeudor(solicitudDto.getIdUsuario())
					.setMonto(Monto)
					.setNoQuincenas(Integer.valueOf(getAttributeFromList(TipoAtributoSolicitudEnum.NO_QUINCENAS,
							solicitudDto.getAttributesAsList()).getValor()))
					.setSaldoPendiente(Monto)
					//TODO:  tomar la taza interes de la tabla del catalogo
					.setTasaInteres(Constants.TASA_INTERES)
					.setSolicitud(solicitudMapper.getEntityFromSolicitudDto(solicitudDto));
			prestamoRepository.save(prestamoBuilder.build());
			// TODO: AGREGAR CONTENIDO DEL TEXTO
			String texto = "Texto PDF";
			SolicitudPdfModelDtoBuilder modelBuilderDto = new SolicitudPdfModelDtoBuilder().setFecha(new Date())
					.setTitulo("Solicitud de adhesión al Programa de ahorro Voluntario").setTexto(texto)
					.setNombre(usuario.getNombre());
			FileConfig fileConfig = new FileConfig(TipoArchivoEnum.PDF, "SolicitudPrestamo",
					pdfServiceGenerator.generateSolicitudesAhorroPdf(modelBuilderDto.build(), solicitudDto.getId()));
			mailService.sentEmail(usuario.getEmail(),
					String.format("Notificacion de finalizacion de la solicitud:%s", solicitudDto.getTipo()),
					String.format("Hola %s,\n\nSe completo  tu solicitud con el folio %d del tipo %s \n\nSaludos.",
							usuario.getNombre(), solicitudDto.getId(), solicitudDto.getTipo()),
					fileConfig);
		} else {
			mailService.sentEmail(usuario.getEmail(),
					String.format("Notificacion de autorizacion de la solicitud:%s", solicitudDto.getTipo()),
					String.format(
							"Hola %s,\n\nSe realizo la validacion numero  %d para tu solicitud con el folio:%d del tipo %s en el area %s \n\nSaludos.",
							usuario.getNombre(), validacionDto.getNumeroValidacion(), solicitudDto.getId(),
							solicitudDto.getTipo(), validacionDto.getArea()));
		}
	}

	@Override
	public void rechazo(SolicitudDto solicitudDto, ValidacionSolicitudDto validacionDto) throws IsbgServiceException {
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
