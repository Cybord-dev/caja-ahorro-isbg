package com.business.cybord.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
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


	public Page<ReporteSaldosDto> getSaldosAhorrosCurrentCaja(Map<String, String> parameters) {
		int page = (parameters.get("page") == null) ? 0 : Integer.valueOf(parameters.get("page"));
		int size = (parameters.get("size") == null) ? 10 : Integer.valueOf(parameters.get("size"));
		return reportesSaldosDao.findAll(parameters, PageRequest.of(page, size, Sort.by("fechaActualizacion")));
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

	public List<SaldoAhorroDto> insertBulk(List<SaldoAhorroDto> saldos, Authentication authentication) {
		List<SaldoAhorro> ahorros = mapper.getEntitysFromDtos(saldos);
		OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
		if (oidcUser != null && oidcUser.getAttributes() != null && oidcUser.getEmail() != null) {
			if (saldos != null && !saldos.isEmpty()) {
				ahorros.forEach(a -> a.setOrigen(oidcUser.getEmail()));
				ahorros = respository.saveAll(ahorros);
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esta vacia la lista");
			}
			return mapper.getDtosFromEntity(ahorros);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "No estaas logeado");
		}

	}

	

}
