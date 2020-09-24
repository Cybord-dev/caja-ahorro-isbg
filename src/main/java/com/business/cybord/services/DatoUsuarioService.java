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

		public DatosUsuarioDto insertarNuevoDatoUsuario(DatosUsuarioDto datosUsuario,int idUsuario) {
			Optional<Usuario> usuario= usuariosRepository.findById(idUsuario);
			if (usuario.isPresent()) {
				DatosUsuario datos = repository.save(mapper.getDatosEntityFromDatosUsuarioDto(datosUsuario));
				datos.setUsuario(usuario.get());
				return mapper.getDtoFromDatosusuarioEntity(datos);
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						String.format("El dato %s ya existe", datosUsuario.getTipoDato()));
			}
		}

		public DatosUsuarioDto actualizarDatoUsuario(DatosUsuarioDto datosUsuario,int id) {
			Optional<DatosUsuario> datosusuarioEntity = repository
					.findById(id);
			if (datosusuarioEntity.isPresent()) {
				datosusuarioEntity.get().setDato(datosUsuario.getDato());
				datosusuarioEntity.get().setRelevancia(datosUsuario.isRelevancia());
				return mapper.getDtoFromDatosusuarioEntity(repository.save(datosusuarioEntity.get()));
			} else
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						String.format("El dato %s no existe", datosUsuario.getTipoDato()));
		}

		public void borraDatoUsuario(Integer id) {
			DatosUsuario entity = repository.findById(id).orElseThrow(
					() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("El Dato no existe %s", id)));
			repository.delete(entity);
		}

}
