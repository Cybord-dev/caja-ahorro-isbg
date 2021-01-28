package com.business.cybord.services;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.sql.SQLException;
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
import com.business.cybord.models.dtos.PrestamoDto;
import com.business.cybord.models.dtos.SaldoPrestamoDto;
import com.business.cybord.models.entities.Prestamo;
import com.business.cybord.models.entities.SaldoPrestamo;
import com.business.cybord.models.enums.EstatusPrestamoEnum;
import com.business.cybord.models.enums.TipoSaldoPrestamoEnum;
import com.business.cybord.repositories.PrestamoRepository;
import com.business.cybord.repositories.SaldoPrestamoRepository;
import com.business.cybord.utils.builder.SaldoPrestamoBuilder;
import com.business.cybord.repositories.PrestamoRepository;
import com.business.cybord.repositories.SaldoPrestamoRepository;



@Service
public class PrestamoService {

	@Autowired
	private PrestamoRepository repository;
	
	@Autowired
	private SaldoPrestamoRepository saldosRepository;

	@Autowired
	private PrestamoMapper mapper;
	
	
	

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

	public List<SaldoPrestamoDto> generarSaldoPrestamo() {
		List<Prestamo> prestamosActivoTraspasado = repository.findActivoTraspasado();

		List<Prestamo> activos = prestamosActivoTraspasado.stream()
				.filter(p -> p.getEstatus().equals(EstatusPrestamoEnum.ACTIVO.toString())).collect(Collectors.toList());

		List<Prestamo> traspasados = prestamosActivoTraspasado.stream()
				.filter(p -> p.getEstatus().equals(EstatusPrestamoEnum.TRASPASADO.toString()))
				.collect(Collectors.toList());
		
		List<SaldoPrestamo> generados = new ArrayList<>();

		for (Prestamo activo : activos) {

			Double sum = montoEfectivamentePagado(activo);

			if (sum == activo.getMonto().doubleValue()) {
				activo.setEstatus(EstatusPrestamoEnum.TERMINADO.toString());
				repository.save(activo);
			} else {
				generados.add(createSaldoPrestamoPago(activo));
				generados.add(createSaldoPrestamoInteres(activo));
			}

		}

		for (Prestamo traspasado : traspasados) {
			Double sum = montoEfectivamentePagado(traspasado);

			if (sum == traspasado.getMonto().doubleValue()) {
				traspasado.setEstatus(EstatusPrestamoEnum.TRASPASADO_TERMINADO.toString());
				repository.save(traspasado);
			} else {
				generados.add(createSaldoPrestamoPago(traspasado));
			}

		}
		
		return saldoPrestamoMapper.getDtosFromEntity(generados);

	}
	
	private SaldoPrestamo createSaldoPrestamoPago(Prestamo prestamo) {
		SaldoPrestamo saldoPrestamo = new SaldoPrestamoBuilder()
				.setIdPrestamo(prestamo.getId())
				.setTipo(TipoSaldoPrestamoEnum.PAGO.toString())
				.setMonto(prestamo.getMonto().doubleValue() / prestamo.getNoQuincenas() )
				.setValidado(false)
				.build();
		return saldoPrestamoRespository.save(saldoPrestamo);
			
	}
	
	private SaldoPrestamo createSaldoPrestamoInteres(Prestamo prestamo) {
		SaldoPrestamo saldoPrestamo = new SaldoPrestamoBuilder()
				.setIdPrestamo(prestamo.getId())
				.setTipo(TipoSaldoPrestamoEnum.INTERES.toString())
				.setMonto(prestamo.getMonto().doubleValue()* (prestamo.getTasaInteres().doubleValue() / 100) )
				.setValidado(false)
				.build();
		return saldoPrestamoRespository.save(saldoPrestamo);
	}
	
	private Double montoEfectivamentePagado(Prestamo prestamo) {
		return prestamo.getSaldosPrestamo().stream()
				.filter(sp-> sp.getTipo().equals(TipoSaldoPrestamoEnum.PAGO.toString()))
				.filter(sp-> sp.getValidado()== true)
				.mapToDouble(sp-> sp.getMonto().doubleValue())
				.sum();
	}

}
