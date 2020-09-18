package com.business.cybord.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.Rol;
import com.business.cybord.entities.Usuario;
import com.business.cybord.mappers.RolMapper;
import com.business.cybord.models.dtos.RolDto;

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
	
	public List<RolDto> getRoles() {
		List<Rol> result = repository.findAll();
		return rolMapper.getDtosFromRolsEntity(result);
	}
	
	public RolDto insertNuevoRol(Integer userId,RolDto roleDto) {
		Usuario entity = repositoryUsuario.findById(userId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Usuario no existe %d", userId)));
		Optional<Rol> rol = repository.findByIdRolAndIdUsuario(userId, roleDto.getId());
		if(rol.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Ya existe el rol con el nombre %s para el user %d",roleDto.getRolname().getNombre(),userId));
		}else {
			Rol role = rolMapper.getEntityFromRolDto(roleDto);
			role.setUsuario(entity);
			return rolMapper.getDtoFromRolEntity(repository.save(role));
		}
	}
	
	public List<RolDto> getRolesPorUsuarioId(Integer id) {
		Usuario entity = repositoryUsuario.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Usuario no existe %d", id)));
		return rolMapper.getDtosFromRolsEntity(repository.findByUserId(entity.getId()));
	}
	
	public void borrarRolePorUsuarioIdyIdRol(Integer userId, Integer id) {
		Usuario entity = repositoryUsuario.findById(userId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Usuario no existe %d", userId)));
		Rol rol = repository.findByIdUsuarioAndId(entity.getId(), id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Rol no existe %d", id)));
		;
		repository.delete(rol);
	}

}
