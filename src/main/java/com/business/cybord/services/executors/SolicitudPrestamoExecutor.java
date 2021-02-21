package com.business.cybord.services.executors;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.business.cybord.mappers.SolicitudMapper;
import com.business.cybord.models.Constants;
import com.business.cybord.models.Constants.SqlConstants;
import com.business.cybord.models.config.FileConfig;
import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.dtos.ValidacionSolicitudDto;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.models.entities.ValidacionAval;
import com.business.cybord.models.enums.EstatusPrestamoEnum;
import com.business.cybord.models.enums.EventFactoryTypeEnum;
import com.business.cybord.models.enums.TipoAtributoSolicitudEnum;
import com.business.cybord.models.enums.TipoPdfEnum;
import com.business.cybord.models.enums.config.TipoArchivoEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.repositories.PrestamoRepository;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.repositories.ValidacionAvalRepository;
import com.business.cybord.services.CatalogoService;
import com.business.cybord.services.MailService;
import com.business.cybord.services.PdfServiceGenerator;
import com.business.cybord.utils.builder.PrestamoBuilder;
import com.business.cybord.utils.builder.SolicitudPrestamoPdfModelDtoBuilder;
import com.business.cybord.utils.helper.FileHelper;

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

	@Autowired
	private CatalogoService catalogoService;

	@Autowired
	private FileHelper fileHelper;

	@Autowired
	private ValidacionAvalRepository validacionAvalRepository;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(SqlConstants.DATE_FORMAT);

	@Override
	public void execute(SolicitudDto solicitudDto, ValidacionSolicitudDto validacionDto) throws IsbgServiceException {
		Usuario usuario = repositoryUsuario.findById(solicitudDto.getIdUsuario())
				.orElseThrow(() -> new IsbgServiceException("Error actualizando datos en solicitud ahorro",
						String.format("El usuario  %d no existe", solicitudDto.getIdUsuario()),
						HttpStatus.CONFLICT.value()));

		if (solicitudDto.getStatus().equals(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState())) {

			List<ValidacionAval> avales = validacionAvalRepository.findByIdSolicitud(solicitudDto.getId());

			Integer numQuincenas = Integer.valueOf(
					getAttributeFromList(TipoAtributoSolicitudEnum.NO_QUINCENAS, solicitudDto.getAttributesAsList())
							.getValor());
			String terminationDate = getAttributeFromList(TipoAtributoSolicitudEnum.FECHA,
					solicitudDto.getAttributesAsList()).getValor();

			BigDecimal monto = new BigDecimal(
					getAttributeFromList(TipoAtributoSolicitudEnum.MONTO, solicitudDto.getAttributesAsList())
							.getValor());

			BigDecimal interes = monto.divide(new BigDecimal(100), 2, RoundingMode.FLOOR)
					.multiply(new BigDecimal(numQuincenas));

			PrestamoBuilder prestamoBuilder = new PrestamoBuilder().setEstatus(EstatusPrestamoEnum.ACTIVO.name())
					.setFechaTerminacion(calculaFechaTerminacion(numQuincenas, terminationDate))
					.setIdDeudor(solicitudDto.getIdUsuario()).setMonto(monto).setNoQuincenas(numQuincenas)
					.setSaldoPendiente(monto)
					.setTasaInteres(new BigDecimal(catalogoService
							.getCatPropiedadByTipoAndNombre(Constants.TIPO_CONFIGURACIONES, Constants.TASA_INTERES)
							.getValor()))
					.setSolicitud(solicitudMapper.getEntityFromSolicitudDto(solicitudDto));
			prestamoRepository.save(prestamoBuilder.build());
			String texto = "Yo aval manifiesto que acepto pagar a mi entera satisfacción el saldo deudor que tenga el solicitante, de acuerdo a la parte proporcional del adeudo contraído al momento de que el solicitante no se le pueda retener de su pago de nómina por la causa que sea.";
			SolicitudPrestamoPdfModelDtoBuilder modelBuilderDto = new SolicitudPrestamoPdfModelDtoBuilder()
					.setFecha(solicitudDto.getFechaEjecucion()).setTitulo("SOLICITUD DE PRESTAMO AL PROGRAMA DE AHORRO")
					.setTexto(texto).setNombre(usuario.getNombre()).setNoEmpleado(usuario.getNoEmpleado())
					.setCantidad(monto.toString()).setInteres(interes.toString())
					.setDescuentoQuincenal(
							monto.add(interes).divide(new BigDecimal(numQuincenas), 2, RoundingMode.FLOOR).toString())
					.setQuincenas(numQuincenas.toString()).setTotal(monto.add(interes).toString());
			avales.forEach(a -> modelBuilderDto.addAval(a.getNombreAval()));
			FileConfig fileConfig = new FileConfig(TipoArchivoEnum.PDF, "SolicitudPrestamo",
					pdfServiceGenerator.generateSolicitudesAhorroPdf(TipoPdfEnum.PRESTAMO,
							fileHelper.solicitudPrestamoXmlToPdf(modelBuilderDto.build()), solicitudDto.getId()));
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

	private Date calculaFechaTerminacion(int numQuincenas, String date) {
		LocalDate terminationDate = LocalDate.parse(date, formatter);
		int meses = numQuincenas / 2;
		int dias = numQuincenas % 2;
		terminationDate = terminationDate.plusMonths(meses).plusDays(dias * 15);
		return Date.from(terminationDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

}
