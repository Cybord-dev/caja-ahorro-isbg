package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.business.cybord.entities.Solicitud;
import com.business.cybord.entities.Usuario;

public interface SolicitudRepository extends CrudRepository<Solicitud, Integer>{
	List<Solicitud> findByIdUsuario(int idU);
	Optional<Solicitud> findByIdUsuarioAndId(int idU, int id);
}
