package com.business.cybord.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.mappers.RolMapper;
import com.business.cybord.models.dtos.RolCatDto;
import com.business.cybord.models.dtos.RolDto;
import com.business.cybord.models.entities.Rol;
import com.business.cybord.models.entities.RolCat;
import com.business.cybord.models.entities.Usuario;
import com.business.cybord.repositories.CatRolRepository;
import com.business.cybord.repositories.RolRepository;
import com.business.cybord.repositories.UsuariosRepository;

@Service
public class RolService {

	@Autowired
	private RolMapper rolMapper;

	@Autowired
	private RolRepository repository;

	@Autowired
	private UsuariosRepository repositoryUsuario;

	@Autowired
	private CatRolRepository catRolRepository;

	private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

	public List<RolDto> getRoles() {
		List<Rol> result = repository.findAll();
		return rolMapper.getDtosFromRolsEntity(result);
	}

	public RolDto insertRol(Integer idUser, RolCatDto rolCatDto) {
		Usuario entity = repositoryUsuario.findById(idUser).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Usuario no existe %d", idUser)));

		Rol usuarioRol = new Rol();
		RolCat rolCat = catRolRepository.getRolByNombre(rolCatDto.getNombre())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("El rol no existe nombre= %s", rolCatDto.getNombre())));

		usuarioRol.setRolname(rolCat);
		usuarioRol.setUsuario(entity);
		log.info("Insertando:  {} / {}", rolCat, (entity.getId()));
		return rolMapper.getDtoFromRolEntity(repository.save(usuarioRol));
	}

	public List<RolDto> getRolesPorUsuarioId(Integer id) {
		Usuario entity = repositoryUsuario.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Usuario no existe %d", id)));
		return rolMapper.getDtosFromRolsEntity(repository.findByUserId(entity.getId()));
	}

	public void borrarRolePorNombre(Integer idUsuario,String nombre) {
		Rol rol = repository.findByIdRolNameAndIdUsuario(nombre,idUsuario)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El rol ya ha sido borrado"));
		repository.delete(rol);
	}

}
