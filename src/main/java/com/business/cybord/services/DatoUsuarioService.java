package com.business.cybord.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.mappers.DatoUsuarioMapper;
import com.business.cybord.models.dtos.DatosUsuarioDto;
import com.business.cybord.models.entities.DatosUsuario;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.repositories.DatosUsuarioRepository;
import com.business.cybord.repositories.UsuariosRepository;

@Service
public class DatoUsuarioService {

	@Autowired
	private DatosUsuarioRepository repository;

	@Autowired
	private UsuariosRepository usuariosRepository;

	@Autowired
	private DatoUsuarioMapper mapper;
	
	public DatosUsuarioDto insertarNuevoDatoUsuario(DatosUsuarioDto datosUsuario, Integer idUsuario) {
		Usuario usuario = usuariosRepository.findById(idUsuario)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Usuario no existe %d", idUsuario)));
		Optional<DatosUsuario> dato = repository.findByTipoDatoAndIdUsuario(datosUsuario.getTipoDato(),
				usuario.getId());
		if (dato.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("El dato ya existe para %d", usuario.getId()));
		} else {
			DatosUsuario datos = mapper.getDatosEntityFromDatosUsuarioDto(datosUsuario);
			datos.setUsuario(usuario);
			datos = repository.save(datos);

			return mapper.getDtoFromDatosusuarioEntity(datos);
		}

	}

	public DatosUsuarioDto actualizarDatoUsuario(int idUsuario, String tipoDato, DatosUsuarioDto datosUsuario) {
		Optional<DatosUsuario> dato = repository.findByTipoDatoAndIdUsuario(tipoDato, idUsuario);
		if(!dato.isPresent()) {
			return insertarNuevoDatoUsuario(datosUsuario, idUsuario);
		}else {
			dato.get().setDato(datosUsuario.getDato());
			dato.get().setRelevancia(datosUsuario.isRelevancia());
			return mapper.getDtoFromDatosusuarioEntity(repository.save(dato.get()));
		}
		

	}

	public void borraDatoUsuario(Integer id) {
		DatosUsuario entity = repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("El Dato no existe %s", id)));
		repository.delete(entity);
	}

}
