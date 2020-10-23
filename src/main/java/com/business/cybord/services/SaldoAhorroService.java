package com.business.cybord.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.mappers.SaldoAhorroMapper;
import com.business.cybord.models.dtos.SaldoAhorroDto;
import com.business.cybord.models.dtos.composed.ReporteSaldosDto;
import com.business.cybord.models.entities.SaldoAhorro;
import com.business.cybord.repositories.SaldoAhorroRepository;
import com.business.cybord.repositories.dao.ReportesSaldosDao;

@Service
public class SaldoAhorroService {

	@Autowired
	private SaldoAhorroRepository respository;

	@Autowired
	private SaldoAhorroMapper mapper;

	@Autowired
	private ReportesSaldosDao reportesSaldosDao;

	public List<ReporteSaldosDto> getSaldosAhorrosCurrentCaja() {
		return reportesSaldosDao.getReportesBySaldos();
	}

	public List<SaldoAhorroDto> getSaldosAhorroByUsuario(Integer id) {
		return mapper.getDtosFromEntity(respository.findByIdUsuario(id));
	}

	public SaldoAhorroDto getSaldoAhorroByIdAndIdUsuario(Integer idUsuario, Integer idSaldo) {
		Optional<SaldoAhorro> saldoAhorro = respository.findByIdUsuarioAndId(idUsuario, idSaldo);
		if (saldoAhorro.isPresent()) {
			return mapper.getDtoFromEntity(saldoAhorro.get());

		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("No existe una cohencidencia de saldo y suauario %d", idUsuario));
		}
	}

	public SaldoAhorroDto insertSadoAhorro(Integer userId, SaldoAhorroDto saldoAhorroDto) {
		Optional<SaldoAhorro> prestamoEntity = respository.findByIdUsuarioAndId(userId, saldoAhorroDto.getId());

		if (prestamoEntity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("Ya existe un saldo usuario %d", userId));
		} else {
			return mapper.getDtoFromEntity(respository.save(mapper.getEntityFromDto(saldoAhorroDto)));
		}
	}

}
