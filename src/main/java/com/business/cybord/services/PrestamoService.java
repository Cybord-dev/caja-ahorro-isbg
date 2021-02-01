package com.business.cybord.services;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.business.cybord.models.dtos.PrestamoDto;
import com.business.cybord.models.dtos.SaldoPrestamoDto;
import com.business.cybord.models.entities.Prestamo;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.models.entities.ValidacionAval;
import com.business.cybord.models.enums.EstatusPrestamoEnum;
import com.business.cybord.models.enums.TipoSaldoPrestamoEnum;
import com.business.cybord.repositories.PrestamoRepository;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.repositories.ValidacionAvalRepository;
import com.business.cybord.repositories.dao.PrestamoDao;
import com.business.cybord.repositories.dao.SaldoPrestamoDao;
import com.business.cybord.utils.builder.PrestamoBuilder;
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
	private ValidacionAvalRepository avalRepository;

	@Autowired
	private UsuariosRepository usuarioRepository;

	private static final Logger log = LoggerFactory.getLogger(PrestamoService.class);

	public Page<PrestamoDto> findPrestamosByFiltros(Map<String, String> parameters) {
		int page = (parameters.get("page") == null) ? 0 : Integer.valueOf(parameters.get("page"));
		int size = (parameters.get("size") == null) ? 10 : Integer.valueOf(parameters.get("size"));
		return dao.findAll(parameters, PageRequest.of(page, size, Sort.by("fechaActualizacion")));
	}

	public List<PrestamoDto> getPrestamosdeUnUsuarioById(Integer id) {
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

	public PrestamoDto getPrestamoPorIdPrestamoYIdusuario(Integer idUsuario, Integer idPrestamo) {
		Optional<Prestamo> prestamo = repository.findByIdAndIdDeudor(idPrestamo, idUsuario);
		if (prestamo.isPresent()) {
			return mapper.getDtoFromEntity(prestamo.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe un usuario para ese prestamo");
		}
	}

	public PrestamoDto getPrestamoPorIdPrestamoYIdusuarioYIdSaldo(Integer idUsuario, Integer idPrestamo,
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
				.divide(new BigDecimal(avales.size()));
		prestamo.setEstatus(EstatusPrestamoEnum.A_PAGAR_POR_AVAL.name());
		repository.save(prestamo);
		List<Prestamo> prestamosGenerados = new ArrayList<>();
		for (ValidacionAval aval : avales) {
			// TODO:CAMBIAR LA BUSQUEDA POR ID_USUARIO
			Usuario usuarioAval = usuarioRepository.findByNoEmpleado(aval.getNoEmpleadoAval())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							String.format("No existe el usuario con numero de empleado %s", aval.getNoEmpleadoAval())));
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

	private SaldoPrestamoDto createSaldoPrestamoPago(Prestamo prestamo) {
		SaldoPrestamoDto saldoPrestamo = new SaldoPrestamoBuilder().setIdPrestamo(prestamo.getId())
				.setIdUsuario(prestamo.getIdDeudor()).setMontoPrestamo(prestamo.getMonto())
				.setNoQuincenas(prestamo.getNoQuincenas()).setSaldoPendiente(prestamo.getSaldoPendiente())
				.setTipo(TipoSaldoPrestamoEnum.PAGO.name())
				.setMonto(prestamo.getMonto().divide(new BigDecimal(prestamo.getNoQuincenas()))).setValidado(false)
				.setOrigen("SISTEMA").build();
		return saldosDao.insertSaldoPrestamo(saldoPrestamo);

	}

	private SaldoPrestamoDto createSaldoPrestamoInteres(Prestamo prestamo) {
		SaldoPrestamoDto saldoPrestamo = new SaldoPrestamoBuilder().setIdPrestamo(prestamo.getId())
				.setIdUsuario(prestamo.getIdDeudor()).setMontoPrestamo(prestamo.getMonto())
				.setNoQuincenas(prestamo.getNoQuincenas()).setSaldoPendiente(prestamo.getSaldoPendiente())
				.setTipo(TipoSaldoPrestamoEnum.INTERES.name())
				.setMonto(prestamo.getMonto().multiply(prestamo.getTasaInteres().divide(new BigDecimal(100))))
				.setValidado(false).setOrigen("SISTEMA").build();
		return saldosDao.insertSaldoPrestamo(saldoPrestamo);
	}

	private BigDecimal montoEfectivamentePagado(Prestamo prestamo) {
		return prestamo.getSaldosPrestamo().stream()
				.filter(sp -> !sp.getTipo().equals(TipoSaldoPrestamoEnum.INTERES.name()))
				.filter(sp -> sp.getValidado() == true).map(sp -> sp.getMonto())
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
	}

}
