package com.business.cybord.services.executors;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.business.cybord.models.config.FileConfig;
import com.business.cybord.models.dtos.DatosUsuarioDto;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionSolicitudDto;
import com.business.cybord.models.entities.AtributoSolicitud;
import com.business.cybord.models.entities.DatosUsuario;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.models.enums.EventFactoryTypeEnum;
import com.business.cybord.models.enums.TipoAtributoSolicitudEnum;
import com.business.cybord.models.enums.TipoAtributoUsuarioEnum;
import com.business.cybord.models.enums.config.TipoArchivoEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.services.CatalogosCacheService;
import com.business.cybord.services.DatoUsuarioService;
import com.business.cybord.services.MailService;
import com.business.cybord.services.PdfServiceGenerator;
import com.business.cybord.utils.builder.SolicitudPdfModelDtoBuilder;
import com.business.cybord.utils.helper.NumberTranslatorHelper;

@Service
@Qualifier("SolicitudAhorroExecutor")
public class SolicitudAhorroExecutor implements SolicitudExecutor {

	@Autowired
	private UsuariosRepository repositoryUsuario;

	@Autowired
	private DatoUsuarioService datoUsuarioService;

	@Autowired
	private MailService mailService;

	@Autowired
	private PdfServiceGenerator pdfServiceGenerator;

	@Autowired
	private NumberTranslatorHelper numberTranslatorHelper;
	
	@Autowired
	private CatalogosCacheService catalogosCacheService;

	@Override
	public void execute(SolicitudDto solicitudDto, ValidacionSolicitudDto validacionDto) throws IsbgServiceException {
		Usuario usuario = repositoryUsuario.findById(solicitudDto.getIdUsuario())
				.orElseThrow(() -> new IsbgServiceException("Error actualizando datos en solicitud ahorro",
						String.format("El usuario  %d no existe", solicitudDto.getIdUsuario()),
						HttpStatus.CONFLICT.value()));

		if (solicitudDto.getStatus().equals(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState())) {
			AtributoSolicitud atributo = solicitudDto.getAttributesAsList().stream()
					.filter(a -> a.getNombre().equals(TipoAtributoSolicitudEnum.MONTO.name())).findFirst()
					.orElseThrow(() -> new IsbgServiceException("No existe el monto en la solicitud",
							"No existe el monto en la solicitud", HttpStatus.CONFLICT.value()));
			datoUsuarioService.insertarNuevoDatoUsuario(
					new DatosUsuarioDto(TipoAtributoUsuarioEnum.AHORRO.name(), atributo.getValor(), true),
					usuario.getId());
			usuario.setAhorrador(true);
			repositoryUsuario.save(usuario);
			Optional<DatosUsuario> oficina = usuario.getDatosUsuario().stream()
					.filter(a -> a.getTipoDato().equals(TipoAtributoUsuarioEnum.OFICINA.name())).findFirst();
			String cadenaOficina="";
			if(oficina.isPresent()) {
				cadenaOficina="";
				cadenaOficina=catalogosCacheService.getCatalogo(oficina.get().getDato()).orElse("");
			}
			
			AtributoSolicitud fecha = solicitudDto.getAttributesAsList().stream()
					.filter(a -> a.getNombre().equals(TipoAtributoSolicitudEnum.FECHA.name())).findFirst()
					.orElseThrow(() -> new IsbgServiceException("No existe el monto en la solicitud",
							"No existe el monto en la solicitud", HttpStatus.CONFLICT.value()));
			
			String texto = String.format(
					"%s, con el número de trabajador %s , adscrito a la Oficina de %s autorizo que por este medio se "
					+ "descuente de mi pago de Nomina, la cantidad de $%s(%s) a partir del dia %s.Durante el periodo "
					+ "correspondiente ,autorizo que la cantidad retenida sea depositada en la cuenta del PROGRAMA DE AHORRO VOLUNTARIO "
					+ " estoy de acuerdo que la cantidad ahorrada y los intereses que se hubiesen generado me sean entregados al término del periodo.",
					usuario.getNombre(), usuario.getNoEmpleado(), cadenaOficina,
					atributo.getValor(),
					numberTranslatorHelper.getStringNumber(new BigDecimal(atributo.getValor()), "MXN"),fecha.getValor());
			SolicitudPdfModelDtoBuilder modelBuilderDto = new SolicitudPdfModelDtoBuilder().setFecha(new Date())
					.setTitulo("Solicitud de adhesión al Programa de ahorro Voluntario").setTexto(texto)
					.setNombre(usuario.getNombre());
			FileConfig fileConfig = new FileConfig(TipoArchivoEnum.PDF, "SolicitudAhorro",
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
