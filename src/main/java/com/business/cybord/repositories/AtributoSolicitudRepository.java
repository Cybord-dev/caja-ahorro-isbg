package com.business.cybord.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.business.cybord.entities.AtributoSolicitud;

@Repository
public interface AtributoSolicitudRepository extends CrudRepository<AtributoSolicitud, Integer>{
	Optional<AtributoSolicitud> findByIdSolicitudAndId(int ids, int id);
}
