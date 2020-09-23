package com.business.cybord.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.business.cybord.entities.SaldoAhorro;
import com.business.cybord.mappers.SaldoAhorroMapper;
import com.business.cybord.models.dtos.SaldoAhorroDto;
import com.business.cybord.repositories.SaldoAhorroRepository;

@Service
public class SaldoAhorroService {
	
	@Autowired
	private SaldoAhorroRepository respository;
	
	@Autowired
	private SaldoAhorroMapper mapper;

	public Page<SaldoAhorroDto> getAhorrosByParamsUsuario(String nombre, String email,
			 Date since, Date to, int page, int size){
		Date start = (since == null) ? new org.joda.time.DateTime().minusYears(1).toDate() : since;
		Date end = (to == null) ? new Date() : to;
		Page<SaldoAhorro> result = respository.findAllByParams(String.format("%%%s%%", nombre),
				String.format("%%%s%%", email),start, end,PageRequest.of(page, size, 
						Sort.by("fechaActualizacion").descending()));		
		return  new PageImpl<>(mapper.getDtosFromEntity(result.getContent()), result.getPageable(),
				result.getTotalElements());
	}

	public List<SaldoAhorroDto> getSaldosAhorroDeUnUsuarioPorSuId(Integer id) {
		return mapper.getDtosFromEntity(respository.findByIdUsuario(id));
	}
	
	public SaldoAhorroDto getSaldoAhorroPorIdYIdusuario(Integer idUsuario, Integer idSaldo) {
		Optional<SaldoAhorro> saldoAhorro = respository.findByIdUsuarioAndId( idUsuario,idSaldo);
		if(saldoAhorro.isPresent()) {
			return mapper.getDtoFromEntity(saldoAhorro.get());
			
		}else {		
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("No existe una cohencidencia de saldo y suauario %d",idUsuario));
		}	
	}
	
	public SaldoAhorroDto insertSadoAhorro(Integer userId,SaldoAhorroDto saldoAhorroDto) {	
		Optional<SaldoAhorro> prestamoEntity = respository.findByIdUsuarioAndId( userId,saldoAhorroDto.getId());
	
		if(prestamoEntity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Ya existe un saldo usuario %d",userId));
		}else {		
			return mapper.getDtoFromEntity(respository.save(mapper.getEntityFromDto(saldoAhorroDto)));
		}
	}

}
