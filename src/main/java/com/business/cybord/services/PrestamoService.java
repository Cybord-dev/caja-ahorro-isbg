package com.business.cybord.services;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.mappers.PrestamoMapper;
import com.business.cybord.mappers.SaldoPrestamoMapper;
import com.business.cybord.models.dtos.PrestamoDto;
import com.business.cybord.models.dtos.SaldoPrestamoDto;
import com.business.cybord.models.entities.Prestamo;
import com.business.cybord.models.entities.SaldoPrestamo;
import com.business.cybord.models.entities.ValidacionAval;
import com.business.cybord.models.enums.EstatusPrestamoEnum;
import com.business.cybord.models.enums.TipoSaldoPrestamoEnum;
import com.business.cybord.repositories.PrestamoRepository;
import com.business.cybord.repositories.SaldoPrestamoRepository;
import com.business.cybord.repositories.ValidacionAvalRepository;
import com.business.cybord.utils.builder.SaldoPrestamoBuilder;



@Service
public class PrestamoService {

	@Autowired
	private PrestamoRepository repository;
	
	@Autowired
	private SaldoPrestamoRepository saldosRepository;

	@Autowired
	private PrestamoMapper mapper;
	
	@Autowired
	private SaldoPrestamoMapper saldoPrestamoMapper;
	
	@Autowired
	private ValidacionAvalRepository avalRepository;
	
	
	

	public List<PrestamoDto> getPrestamosdeUnUsuarioPorSuId(Integer id) {
		return mapper.getDtosFromEntity(repository.findByIdDeudor(id));
	}
	

	public PrestamoDto getPrestamoPorIdPrestamoYIdusuario(Integer idUsuario, Integer idPrestamo) {

		Optional<Prestamo> prestamo = repository.findByIdAndIdDeudor(idPrestamo, idUsuario);
		if (prestamo.isPresent()) {
			return mapper.getDtoFromEntity(prestamo.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe un usuario para ese prestamo");
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
		Prestamo prestamo = repository.findById(idPrestamo).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("El prestamo con id %d  no existe.", idPrestamo)));
		SaldoPrestamo saldo = saldosRepository.save(mapper.getSaldoEntityFromSaldoDto(dto));
		prestamo.setSaldoPendiente(prestamo.getSaldoPendiente().subtract(dto.getMonto()));
		if(BigDecimal.ZERO.compareTo(prestamo.getSaldoPendiente())>=0) {
			prestamo.setEstatus("TERMINADO");
		}
		repository.save(prestamo);
		return mapper.getSaldoDtoFromEntity(saldo);
	}

	@Transactional(rollbackOn = { DataAccessException.class, SQLException.class })
	public List<SaldoPrestamoDto> generarSaldoPrestamo() {
		List<Prestamo> prestamosActivoTraspasado = repository.findActivoTraspasado();

		List<Prestamo> activos = prestamosActivoTraspasado.stream()
				.filter(p -> p.getEstatus().equals(EstatusPrestamoEnum.ACTIVO.name())).collect(Collectors.toList());

		List<Prestamo> traspasados = prestamosActivoTraspasado.stream()
				.filter(p -> p.getEstatus().equals(EstatusPrestamoEnum.TRASPASADO.name()))
				.collect(Collectors.toList());
		
		List<SaldoPrestamo> generados = new ArrayList<>();

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
		
		return saldoPrestamoMapper.getDtosFromEntity(generados);

	}
	
	@Transactional(rollbackOn = { DataAccessException.class, SQLException.class })
	public List<PrestamoDto> traspasarPrestamo(Integer idPrestamo) {
		Prestamo prestamo = repository.findById(idPrestamo)
				.orElseThrow(()->  new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No existe el prestamo con id %d", idPrestamo)));
		
		//TODO validar si el prestamo es de un estatus valido

		List<ValidacionAval> avales = avalRepository.findByIdSolicitud(prestamo.getId());
		
		//TODO validar que exista el aval
		
		//Calcular el numero de quincenas faltantes
				
		BigDecimal montoEfectivamentePagado = montoEfectivamentePagado(prestamo);
		
		//dividir el monto que falte entre los avales
		
		//agregar saldo prestamo correspondiente
		
				
		return null;
	}

	
	private SaldoPrestamo createSaldoPrestamoPago(Prestamo prestamo) {
		SaldoPrestamo saldoPrestamo = new SaldoPrestamoBuilder()
				.setIdPrestamo(prestamo.getId())
				.setTipo(TipoSaldoPrestamoEnum.PAGO.name())
				.setMonto(prestamo.getMonto().divide(new BigDecimal(prestamo.getNoQuincenas())) )
				.setValidado(false)
				.setOrigen("System")
				.build();
		return saldosRepository.save(saldoPrestamo);
			
	}
	
	
	private SaldoPrestamo createSaldoPrestamoInteres(Prestamo prestamo) {
		SaldoPrestamo saldoPrestamo = new SaldoPrestamoBuilder()
				.setIdPrestamo(prestamo.getId())
				.setTipo(TipoSaldoPrestamoEnum.INTERES.name())
				.setMonto(prestamo.getMonto().multiply(prestamo.getTasaInteres().divide(new BigDecimal(100))))
				.setValidado(false)
				.setOrigen("System")
				.build();
		return saldosRepository.save(saldoPrestamo);
	}
	
	private BigDecimal montoEfectivamentePagado(Prestamo prestamo) {
		return prestamo.getSaldosPrestamo().stream()
				.filter(sp-> sp.getTipo().equals(TipoSaldoPrestamoEnum.PAGO.name()))
				.filter(sp-> sp.getValidado()== true)
				.map(sp-> sp.getMonto())
				.reduce(BigDecimal.ZERO, (a,b)-> a.add(b));
	}



}
