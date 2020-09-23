package com.business.cybord.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.Usuario;
import com.business.cybord.mappers.UsuariosMapper;
import com.business.cybord.models.dtos.UsuariosDto;
import com.business.cybord.repositories.DatosUsuarioRepository;
import com.business.cybord.repositories.UsuariosRepository;
import com.business.cybord.util.ConstructorBusquedas;
import com.business.cybord.util.TipoParametro;

@Service
public class UsuarioService {

	@Autowired
	private UsuariosRepository repository;

	@Autowired
	private UsuariosMapper mapper;

	@Autowired
	private DatosUsuarioRepository datosUsuarioRepository;

	private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

	public Page<UsuariosDto> getUsuariosPorParametros(List<TipoParametro> parameters, String page, String size) {
		int pagina = (page == null) ? 0 : Integer.valueOf(page);
		int tamaño = (size == null) ? 10 : Integer.valueOf(size);
		Page<Usuario> result = repository.findAll(ConstructorBusquedas.buildSearchFiltersGeneric(parameters),
				PageRequest.of(pagina, tamaño, Sort.by("fechaActualizacion").descending()));
		return new PageImpl<>(mapper.getUsuariosDtoFromEntities(result.getContent()), result.getPageable(),
				result.getTotalElements());
	}

	public UsuariosDto getUserById(Integer id) {
		log.info("Buscando usuario con id : {}", id);
		Usuario entity = repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("user no existe %d", id)));
		return mapper.getDtoFromUserEntity(entity);
	}

	public UsuariosDto insertarNuevoUsuario(UsuariosDto usuario) {
		Optional<Usuario> entity = repository.findByEmail(usuario.getEmail());
		if (entity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("El dato %s ya existe", usuario.getEmail()));
		} else {
			Usuario datos = repository.save(mapper.getEntityFromUserDto(usuario));
			return mapper.getDtoFromUserEntity(datos);
		}
	}

	public UsuariosDto actualizarUsuario(UsuariosDto usuario) {
		Usuario entity = repository.findByEmail(usuario.getEmail())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("El usuario %s no existe.", usuario.getEmail())));
		entity.setActivo(usuario.getActivo());
		entity.setNombre(usuario.getNombre());
		entity.setTipoUsuario(usuario.getTipoUsuario());
		entity.setNombre(usuario.getNombre());
		entity.setDatosUsuario(usuario.getDatosUsuario());
		return mapper.getDtoFromUserEntity(repository.save(entity));
	}

	public void borrarUsuario(Integer id) {
		Usuario entity = repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("El Usuario no existe %d", id)));
		datosUsuarioRepository.findByIdUsuario(id).stream().forEach(a -> datosUsuarioRepository.delete(a));
		repository.delete(entity);
	}

	
}
