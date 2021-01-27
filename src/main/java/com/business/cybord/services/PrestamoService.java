package com.business.cybord.services;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.mappers.PrestamoMapper;
import com.business.cybord.mappers.SaldoPrestamoMapper;
import com.business.cybord.models.dtos.PrestamoDto;
import com.business.cybord.models.entities.Prestamo;
import com.business.cybord.models.entities.SaldoPrestamo;
import com.business.cybord.models.enums.EstatusPrestamoEnum;
import com.business.cybord.models.enums.TipoSaldoPrestamoEnum;
import com.business.cybord.repositories.PrestamoRepository;
import com.business.cybord.repositories.SaldoPrestamoRepository;
import com.business.cybord.utils.builder.SaldoPrestamoBuilder;

@Service
public class PrestamoService {

	@Autowired
	private PrestamoRepository repository;
	
	@Autowired
	private SaldoPrestamoRepository saldoPrestamoRespository;

	@Autowired
	private PrestamoMapper mapper;
	
	@Autowired
	private SaldoPrestamoMapper saldoPrestamoMapper;
	
	
	private static final Logger log = LoggerFactory.getLogger(PrestamoService.class);

	

	public List<PrestamoDto> getPrestamosdeUnUsuarioPorSuId(Integer id) {
		return mapper.getDtosFromEntity(repository.findByIdDeudor(id));
	}

	public PrestamoDto getPrestamoPorIdPrestamoYIdusuario(Integer idUsuario, Integer idPrestamo) {

		Optional<Prestamo> prestamo = repository.findByIdAndIdDeudor(idPrestamo, idUsuario);
		if (prestamo.isPresent()) {
			return mapper.getDtoFromEntity(prestamo.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("No existe un usuario para ese prestamo"));
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
			prestamoDto.getEstatus();
			prestamo.setSaldosPrestamo(saldoPrestamoMapper.getEntitysFromDtos(prestamoDto.getSaldosPrestamo()));
			return mapper.getDtoFromEntity(repository.save(prestamo));
		}
	}

	public void generarSaldoPrestamo() {
		List<Prestamo> prestamosActivoTraspasado = repository.findActivoTraspasado();

		List<Prestamo> activos = prestamosActivoTraspasado.stream()
				.filter(p -> p.getEstatus().equals(EstatusPrestamoEnum.ACTIVO.toString())).collect(Collectors.toList());

		List<Prestamo> traspasados = prestamosActivoTraspasado.stream()
				.filter(p -> p.getEstatus().equals(EstatusPrestamoEnum.TRASPASADO.toString()))
				.collect(Collectors.toList());

		for (Prestamo activo : activos) {

			Double sum = montoEfectivamentePagado(activo);

			if (sum == activo.getMonto().doubleValue()) {
				activo.setEstatus(EstatusPrestamoEnum.TERMINADO.toString());
				repository.save(activo);
			} else {
				createSaldoPrestamoPago(activo);
				createSaldoPrestamoInteres(activo);
			}

		}

		for (Prestamo traspasado : traspasados) {
			Double sum = montoEfectivamentePagado(traspasado);

			if (sum == traspasado.getMonto().doubleValue()) {
				traspasado.setEstatus(EstatusPrestamoEnum.TRASPASADO_TERMINADO.toString());
				repository.save(traspasado);
			} else {
				createSaldoPrestamoPago(traspasado);
			}

		}

	}
	
	private void createSaldoPrestamoPago(Prestamo prestamo) {
		SaldoPrestamo saldoPrestamo = new SaldoPrestamoBuilder()
				.setIdPrestamo(prestamo.getId())
				.setTipo(TipoSaldoPrestamoEnum.PAGO.toString())
				.setMonto(prestamo.getMonto().doubleValue() / prestamo.getNoQuincenas() )
				.setValidado(false)
				.build();
		saldoPrestamoRespository.save(saldoPrestamo);
			
	}
	
	private void createSaldoPrestamoInteres(Prestamo prestamo) {
		SaldoPrestamo saldoPrestamo = new SaldoPrestamoBuilder()
				.setIdPrestamo(prestamo.getId())
				.setTipo(TipoSaldoPrestamoEnum.INTERES.toString())
				.setMonto(prestamo.getMonto().doubleValue()* (prestamo.getTasaInteres().doubleValue() / 100) )
				.setValidado(false)
				.build();
		saldoPrestamoRespository.save(saldoPrestamo);
	}
	
	private Double montoEfectivamentePagado(Prestamo prestamo) {
		return prestamo.getSaldosPrestamo().stream()
				.filter(sp-> sp.getTipo().equals(TipoSaldoPrestamoEnum.PAGO.toString()))
				.filter(sp-> sp.getValidado()== true)
				.mapToDouble(sp-> sp.getMonto().doubleValue())
				.sum();
	}

}
