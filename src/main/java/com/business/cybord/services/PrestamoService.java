package com.business.cybord.services;
import com.business.cybord.mappers.PrestamoMapper;
import com.business.cybord.mappers.SaldoPrestamoMapper;
import com.business.cybord.models.dtos.PrestamoDto;
import com.business.cybord.models.entities.Prestamo;
import com.business.cybord.repositories.PrestamoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;



@Service
public class PrestamoService {

	@Autowired
	private PrestamoRepository repository;

	@Autowired
	private PrestamoMapper mapper;
	
	@Autowired
	private SaldoPrestamoMapper saldoPrestamoMapper;
	


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
			prestamo.setSaldosPrestamo(mapper.getEntitiesFromDtos(prestamoDto.getSaldosPrestamo()));
			return mapper.getDtoFromEntity(repository.save(prestamo));
		}
	}

}
