package com.business.cybord.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.DatosUsuario;
import com.business.cybord.entities.Usuario;
import com.business.cybord.mappers.DatoUsuarioMapper;
import com.business.cybord.models.dtos.DatosUsuarioDto;
import com.business.cybord.repositories.DatosUsuarioRepository;
import com.business.cybord.repositories.UsuariosRepository;

@Service
public class DatoUsuarioService {

	@Autowired
	private DatosUsuarioRepository datosUsuarioRepository;
	
	@Autowired
	private UsuariosRepository repository;
	
	@Autowired
	private DatoUsuarioMapper mapper;

		public DatosUsuarioDto insertarNuevoDatoUsuario(DatosUsuarioDto datosUsuario) {
			Optional<DatosUsuario> datosusuarioEntity = datosUsuarioRepository
					.findByTipoDatoAndIdUsuario(datosUsuario.getTipoDato(), datosUsuario.getIdUsuario());
			if (datosusuarioEntity.isPresent()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						String.format("El dato %s ya existe", datosUsuario.getTipoDato()));
			} else {

				DatosUsuario datos = datosUsuarioRepository.save(mapper.getDatosEntityFromDatosUsuarioDto(datosUsuario));
				return mapper.getDtoFromDatosusuarioEntity(datos);
			}
		}

		public DatosUsuarioDto actualizarDatoUsuario(int idUsuario, DatosUsuarioDto datosUsuario) {
			Optional<Usuario> usuario = repository.findById(idUsuario);
			Optional<DatosUsuario> datosusuarioEntity = datosUsuarioRepository
					.findByTipoDatoAndIdUsuario(datosUsuario.getTipoDato(), datosUsuario.getIdUsuario());
			if (datosusuarioEntity.isPresent() && usuario.isPresent()) {
				datosusuarioEntity.get().setDato(datosUsuario.getDato());
				datosusuarioEntity.get().setRelevancia(datosUsuario.isRelevancia());
				return mapper.getDtoFromDatosusuarioEntity(datosUsuarioRepository.save(datosusuarioEntity.get()));
			} else
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						String.format("El dato %s no existe", datosUsuario.getTipoDato()));
		}

		public void borraDatoUsuario(Integer id) {
			DatosUsuario entity = datosUsuarioRepository.findById(id).orElseThrow(
					() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("El Dato no existe %s", id)));
			datosUsuarioRepository.delete(entity);
		}

}
