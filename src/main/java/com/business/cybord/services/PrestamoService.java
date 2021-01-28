package com.business.cybord.services;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
		if(BigDecimal.ZERO.compareTo(prestamo.getSaldoPendiente())>0) {
			prestamo.setEstatus("TERMINADO");
		}
		repository.save(prestamo);
		return mapper.getSaldoDtoFromEntity(saldo);
	}

}
