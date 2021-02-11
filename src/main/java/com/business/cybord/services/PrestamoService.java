package com.business.cybord.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.mappers.PrestamoMapper;
import com.business.cybord.mappers.SaldoAhorroMapper;
import com.business.cybord.models.Constants;
import com.business.cybord.models.dtos.CalculoInteresDto;
import com.business.cybord.models.dtos.PrestamoDto;
import com.business.cybord.models.dtos.RecursoDto;
import com.business.cybord.models.dtos.SaldoAhorroDto;
import com.business.cybord.models.dtos.SaldoPrestamoDto;
import com.business.cybord.models.entities.Prestamo;
import com.business.cybord.models.entities.SaldoAhorro;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.models.entities.ValidacionAval;
import com.business.cybord.models.enums.EstatusPrestamoEnum;
import com.business.cybord.models.enums.TipoAhorroEnum;
import com.business.cybord.models.enums.TipoSaldoPrestamoEnum;
import com.business.cybord.models.enums.TipoUsuarioEnum;
import com.business.cybord.repositories.PrestamoRepository;
import com.business.cybord.repositories.SaldoAhorroRepository;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.repositories.ValidacionAvalRepository;
import com.business.cybord.repositories.dao.PrestamoDao;
import com.business.cybord.repositories.dao.SaldoPrestamoDao;
import com.business.cybord.utils.builder.CalculoInteresDtoBuilder;
import com.business.cybord.utils.builder.PrestamoBuilder;
import com.business.cybord.utils.builder.SaldoAhorroBuilder;
import com.business.cybord.utils.builder.SaldoPrestamoBuilder;




@Service
public class PrestamoService {

	@Autowired
	private PrestamoRepository repository;

	@Autowired
	private PrestamoDao dao;

	@Autowired
	private SaldoPrestamoDao saldosDao;

	@Autowired
	private PrestamoMapper mapper;
	
	@Autowired
	private SaldoAhorroMapper mapperSaldoAhorro;
	
	@Autowired
	private CatalogoService catalogoService;
	
	@Autowired
	private SaldoPrestamoService saldoPrestamoService;

	@Autowired
	private ValidacionAvalRepository avalRepository;
	
	@Autowired
	private SaldoAhorroService saldoAhorroService;
	
	@Autowired
	private SaldoAhorroRepository saldoAhorroRepository;

	@Autowired
	private UsuariosRepository usuarioRepository;
	
	@Autowired
	private DownloaderService reportService;

	private static final Logger log = LoggerFactory.getLogger(PrestamoService.class);

	public Page<PrestamoDto> findPrestamosByFiltros(Map<String, String> parameters) {
		int page = (parameters.get("page") == null) ? 0 : Integer.valueOf(parameters.get("page"));
		int size = (parameters.get("size") == null) ? 10 : Integer.valueOf(parameters.get("size"));
		return dao.findAll(parameters, PageRequest.of(page, size, Sort.by("fechaActualizacion")));
	}

	public List<PrestamoDto> getPrestamosByUsuarioId(Integer id) {
		return mapper.getDtosFromEntity(repository.findByIdDeudor(id));
	}

	public List<PrestamoDto> getPrestamosdeUnUsuarioByIdNotCompleted(Integer id) {
		return mapper.getDtosFromEntity(repository.findByIdDeudorNotCompleted(id));
	}

	public Page<SaldoPrestamoDto> getPrestamosyParams(@RequestParam Map<String, String> parameters) {
		int page = (parameters.get("page") == null) ? 0 : Integer.valueOf(parameters.get("page"));
		int size = (parameters.get("size") == null) ? 10 : Integer.valueOf(parameters.get("size"));
		return saldosDao.findAll(parameters, PageRequest.of(page, size, Sort.by("fechaActualizacion")));
	}
	
	public RecursoDto getPrestamosReportParams(Map<String, String> parameters) throws IOException {
		int page = (parameters.get("page") == null) ? 0 : Integer.valueOf(parameters.get("page"));
		int size = (parameters.get("size") == null) ? 10 : Integer.valueOf(parameters.get("size"));
		Page<SaldoPrestamoDto> saldos = saldosDao.findAll(parameters, PageRequest.of(page, size, Sort.by("fechaActualizacion")));

		List<Map<String, String>> data = saldos.getContent().stream().map(s -> {
			Map<String, String> map = new HashMap<>();
			map.put("VALIDADO", (s.getValidado() == Boolean.TRUE)?"SI":"NO");
			map.put("MONTO", s.getMonto().toString());
			map.put("NO QUINCENAS", s.getNoQuincenas().toString());
			map.put("TASA INTERES", String.format("%%%s", s.getTasaInteres().toString()));
			map.put("TIPO EMPLEADO", s.getEstatus());
			map.put("NO EMPLEADO", s.getNoEmpleado());
			map.put("NOMBRE", s.getNombreEmpleado());
			map.put("MONTO PRESTAMO", s.getMontoPrestamo().toString());
			map.put("SALDO PENDIENTE", s.getSaldoPendiente().toString());
			map.put("TIPO", s.getTipo());
			map.put("ESTATUS", s.getEstatus());
			map.put("MODIFICADO", s.getOrigen());
			map.put("FECHA ALTA", s.getFechaCreacion().toString());
			map.put("FECHA MODIFICACION", s.getFechaActualizacion().toString());
			return map;
		}).collect(Collectors.toList());

		return reportService.generateBase64Report("REGISTROS PRESTAMO", data);
	}

	public PrestamoDto getPrestamoByIdPrestamoAndIdusuario(Integer idUsuario, Integer idPrestamo) {
		Optional<Prestamo> prestamo = repository.findByIdAndIdDeudor(idPrestamo, idUsuario);
		if (prestamo.isPresent()) {
			return mapper.getDtoFromEntity(prestamo.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe un usuario para ese prestamo");
		}
	}

	public PrestamoDto getPrestamoByIdPrestamoAndIdusuarioAndIdSaldo(Integer idUsuario, Integer idPrestamo,
			Integer idSaldo) {
		Optional<Prestamo> prestamo = repository.findByIdAndIdDeudorAndIdSaldo(idUsuario, idPrestamo, idSaldo);
		if (prestamo.isPresent()) {
			return mapper.getDtoFromEntity(prestamo.get());
		} else {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No existe el saldo %d", idSaldo));
		}
	}

	public PrestamoDto insertPrestamo(Integer userId, PrestamoDto prestamoDto) {
		Optional<Prestamo> prestamoEntity = repository.findByIdAndIdDeudor(prestamoDto.getId(), userId);
		if (prestamoEntity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("Ya existe un prestamo para ese usuario user %d", userId));
		} else {
			Prestamo prestamo = mapper.getEntityFromDto(prestamoDto);
			prestamo.setSaldosPrestamo(mapper.getSaldoEntitiesFromSaldoDtos(prestamoDto.getSaldosPrestamo()));
			return mapper.getDtoFromEntity(repository.save(prestamo));
		}
	}

	@Transactional(rollbackOn = { DataAccessException.class, SQLException.class })
	public SaldoPrestamoDto insertPagoPrestamo(Integer idPrestamo, SaldoPrestamoDto dto) {
		repository.findById(idPrestamo).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
				String.format("El prestamo con id %d  no existe.", idPrestamo)));
		return saldosDao.insertSaldoPrestamo(dto);
	}

	@Transactional(rollbackOn = { DataAccessException.class, SQLException.class })
	public SaldoPrestamoDto updatePagoPrestamo(Integer idSaldo, SaldoPrestamoDto dto) {
		
		int updated = saldosDao.updateSaldoPrestamo(idSaldo, dto);
		if(updated == 1 && dto.getValidado() && dto.getOrigen() != null) {
			Prestamo prestamo  = repository.findById(dto.getIdPrestamo())
					.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "El saldo no se encuenttra ligado a ningun prestamo"));
			
			prestamo.setSaldoPendiente(prestamo.getSaldoPendiente().subtract(dto.getMonto()));
			
			log.info("Updating saldo pendiente del prestamo : {}", prestamo);
			repository.save(prestamo);
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El saldo no fue correctamente actualizado");
		}
		return dto;
	}

	@Transactional(rollbackOn = { DataAccessException.class, SQLException.class })
	public List<SaldoPrestamoDto> generarSaldoPrestamo() {
		List<Prestamo> prestamosActivoTraspasado = repository.findActivoTraspasado();
		List<Prestamo> activos = prestamosActivoTraspasado.stream()
				.filter(p -> p.getEstatus().equals(EstatusPrestamoEnum.ACTIVO.name())).collect(Collectors.toList());
		List<Prestamo> traspasados = prestamosActivoTraspasado.stream()
				.filter(p -> p.getEstatus().equals(EstatusPrestamoEnum.TRASPASADO.name())).collect(Collectors.toList());
		List<SaldoPrestamoDto> generados = new ArrayList<>();

		for (Prestamo activo : activos) {
			BigDecimal sum = montoEfectivamentePagado(activo);
			if (sum.equals(activo.getMonto())) {
				activo.setEstatus(EstatusPrestamoEnum.TERMINADO.name());
				repository.save(activo);
			} else {
				generados.add(createSaldoPrestamoPago(activo));
				generados.add(createSaldoPrestamoInteres(activo));
			}
		}

		for (Prestamo traspasado : traspasados) {
			BigDecimal sum = montoEfectivamentePagado(traspasado);

			if (sum.equals(traspasado.getMonto())) {
				traspasado.setEstatus(EstatusPrestamoEnum.TRASPASADO_TERMINADO.name());
				repository.save(traspasado);
			} else {
				generados.add(createSaldoPrestamoPago(traspasado));
			}
		}
		return generados;
	}

	@Transactional(rollbackOn = { DataAccessException.class, SQLException.class, ResponseStatusException.class })
	public List<PrestamoDto> traspasarPrestamo(Integer idPrestamo) {
		Prestamo prestamo = repository.findById(idPrestamo)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("No existe el prestamo con id %d", idPrestamo)));

		if (!(prestamo.getEstatus().equals(EstatusPrestamoEnum.ACTIVO.name())
				|| prestamo.getEstatus().equals(EstatusPrestamoEnum.SUSPENDIDO.name()))) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("El prestamo con id %d no tiene el estatus correcto", idPrestamo));
		}
		List<ValidacionAval> avales = avalRepository.findByIdSolicitud(prestamo.getSolicitud().getId());
		if (avales.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("El prestamo con id %d no tiene avales", idPrestamo));
		}
		BigDecimal montoEfectivamentePagado = montoEfectivamentePagado(prestamo);
		BigDecimal saldoPorAval = (prestamo.getMonto().subtract(montoEfectivamentePagado))
				.divide(new BigDecimal(avales.size()),2, RoundingMode.HALF_UP);
		prestamo.setEstatus(EstatusPrestamoEnum.A_PAGAR_POR_AVAL.name());
		repository.save(prestamo);
		List<Prestamo> prestamosGenerados = new ArrayList<>();
		for (ValidacionAval aval : avales) {
			Usuario usuarioAval = usuarioRepository.findById(aval.getIdUsuarioAval())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							String.format("No existe el usuario con id  %d", aval.getIdUsuarioAval())));
			Prestamo prestamoAval = new PrestamoBuilder().setIdDeudor(usuarioAval.getId())
					.setEstatus(EstatusPrestamoEnum.TRASPASADO.name()).setMonto(saldoPorAval)
					.setNoQuincenas(prestamo.getNoQuincenas() - prestamo.getSaldosPrestamo().stream()
							.filter(sp -> sp.getTipo().equals(TipoSaldoPrestamoEnum.PAGO.name()))
							.filter(sp -> sp.getValidado().equals(true)).mapToInt(e -> 1).sum())
					.setSaldoPendiente(saldoPorAval).setFechaTerminacion(prestamo.getFechaTerminacion())
					.setSolicitud(prestamo.getSolicitud()).setTasaInteres(BigDecimal.ZERO).build();
			prestamoAval = repository.save(prestamoAval);
			prestamosGenerados.add(prestamoAval);
		}

		return mapper.getDtosFromEntity(prestamosGenerados);
	}

	public CalculoInteresDto calculoInteres(LocalDate fechaInicial, LocalDate fechaFinal) {
		
		validarFecha(fechaInicial, fechaFinal);		
		
		BigDecimal saldoAhorroTotal = saldoAhorroService.getSaldosAhorroTotal();
		BigDecimal saldoPrestamoInteres = saldoPrestamoService.getSaldoPrestamoInteresByPeriod(fechaInicial, fechaFinal);
		BigDecimal interesRetencion = saldoPrestamoInteres.multiply(
				new BigDecimal(catalogoService.getCatPropiedadByTipoAndNombre(Constants.TIPO_CONFIGURACIONES, Constants.TASA_INTERES_RETENCION).getValor())
				.divide(new BigDecimal(100),2, RoundingMode.FLOOR));
		BigDecimal interesDelPerido = saldoPrestamoInteres.subtract(interesRetencion);
		BigDecimal porcentajeInteresDelPeriodo;
		
		if(saldoAhorroTotal.signum() > 0) {
			porcentajeInteresDelPeriodo = (interesDelPerido.divide(saldoAhorroTotal,6, RoundingMode.FLOOR)).multiply(new BigDecimal(100));
		}else {
			porcentajeInteresDelPeriodo = BigDecimal.ZERO;
		}
		
		return  new CalculoInteresDtoBuilder()
				.setSaldoAhorroTotal(saldoAhorroTotal)
				.setSaldoPrestamoInteresTotal(saldoPrestamoInteres)
				.setInteresRetenido(interesRetencion)
				.setInteresDelPeriodo(interesDelPerido)
				.setPorcentajeInteresDelPeriodo(porcentajeInteresDelPeriodo)
				.build();
		
		
	}
	
	@Transactional(rollbackOn = { DataAccessException.class, SQLException.class, ResponseStatusException.class })
	public List<SaldoAhorroDto> generacionRenglonIntereses(LocalDate fechaInicial, LocalDate fechaFinal) {
		validarFecha(fechaInicial, fechaFinal);
		CalculoInteresDto interesesDto =  calculoInteres(fechaInicial, fechaFinal);
				
		BigDecimal interesRepartido = BigDecimal.ZERO;
		
		List<SaldoAhorro> saldoAhorroCreados = new ArrayList<>();
		
		for(TipoUsuarioEnum tipoAhorrodor : TipoUsuarioEnum.values()) {
			List<Usuario> ahorradores = usuarioRepository.findByTipoUsuarioAndAhorrador(tipoAhorrodor.getTipo(), Boolean.TRUE);
			
			for(Usuario usuario: ahorradores) {
				BigDecimal ahorro = saldoAhorroService.findSaldoAhorroSumByIdUsuario(usuario.getId());
				if(ahorro != null) {
					BigDecimal interesUsurio = ahorro.multiply(interesesDto.getPorcentajeInteresDelPeriodo().divide(new BigDecimal(100),6, RoundingMode.FLOOR));				
					saldoAhorroCreados.add(createSaldoAhorroInteres(usuario.getId(),interesUsurio));
					interesRepartido = interesRepartido.add(interesUsurio);
				}
			}		
		}
		
		if(interesRepartido.compareTo(interesesDto.getInteresDelPerido()) <=0 ) {
			log.info("Interes repartido {}", interesRepartido);
			saldoAhorroCreados.add(createSaldoAhorroInteres(Constants.ID_USUARIO_CAJA,interesesDto.getSaldoPrestamoInteresTotal().subtract(interesRepartido)));
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error en la generacion de intereses");
		}
		
		return mapperSaldoAhorro.getDtosFromEntity(saldoAhorroCreados);
	}

	
	
	private SaldoPrestamoDto createSaldoPrestamoPago(Prestamo prestamo) {
		SaldoPrestamoDto saldoPrestamo = new SaldoPrestamoBuilder().setIdPrestamo(prestamo.getId())
				.setIdUsuario(prestamo.getIdDeudor()).setMontoPrestamo(prestamo.getMonto())
				.setNoQuincenas(prestamo.getNoQuincenas()).setSaldoPendiente(prestamo.getSaldoPendiente())
				.setTipo(TipoSaldoPrestamoEnum.PAGO.name())
				.setMonto(prestamo.getMonto().divide(new BigDecimal(prestamo.getNoQuincenas()),2, RoundingMode.FLOOR))
				.setValidado(false)
				.setOrigen(Constants.ORIGEN_SISTEMA)
				.build();
		return saldosDao.insertSaldoPrestamo(saldoPrestamo);

	}
	
	private SaldoAhorro createSaldoAhorroInteres(Integer idUsuario, BigDecimal monto) {
		SaldoAhorro saldoAhorro = new SaldoAhorroBuilder()
				.setIdUsuario(idUsuario)
				.setMonto(monto)
				.setOrigen(Constants.ORIGEN_SISTEMA)
				.setTipo(TipoAhorroEnum.INTERES.getTipo())
				.build();
		
		return saldoAhorroRepository.save(saldoAhorro);
		
	}

	private SaldoPrestamoDto createSaldoPrestamoInteres(Prestamo prestamo) {
		SaldoPrestamoDto saldoPrestamo = new SaldoPrestamoBuilder().setIdPrestamo(prestamo.getId())
				.setIdUsuario(prestamo.getIdDeudor()).setMontoPrestamo(prestamo.getMonto())
				.setNoQuincenas(prestamo.getNoQuincenas()).setSaldoPendiente(prestamo.getSaldoPendiente())
				.setTipo(TipoSaldoPrestamoEnum.INTERES.name())
				.setMonto(prestamo.getMonto().multiply(prestamo.getTasaInteres().divide(new BigDecimal(100),2, RoundingMode.FLOOR)))
				.setValidado(false).setOrigen(Constants.ORIGEN_SISTEMA).build();
		return saldosDao.insertSaldoPrestamo(saldoPrestamo);
	}

	private BigDecimal montoEfectivamentePagado(Prestamo prestamo) {
		return prestamo.getSaldosPrestamo().stream()
				.filter(sp -> !sp.getTipo().equals(TipoSaldoPrestamoEnum.INTERES.name()))
				.filter(sp -> sp.getValidado()).map(sp -> sp.getMonto())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
	}
	
	private void validarFecha(LocalDate fechaInicial, LocalDate fechaFinal) {
		if(fechaInicial.isAfter(fechaFinal)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("Fecha Incial %s es mayor a fecha final %s  ", fechaInicial, fechaFinal));
		}
	}


}
