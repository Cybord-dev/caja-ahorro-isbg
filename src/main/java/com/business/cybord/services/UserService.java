package com.business.cybord.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.business.cybord.entities.User;
import com.business.cybord.mappers.UserMapper;
import com.business.cybord.models.dtos.UserDto;
import com.business.cybord.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserMapper mapper;

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	public UserDto getUserById(Integer id) {
		log.info("Buscando usuario con id : {}", id);
		User entity = repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("user no existe %d", id)));
		return mapper.getDtoFromUserEntity(entity);
	}

}
