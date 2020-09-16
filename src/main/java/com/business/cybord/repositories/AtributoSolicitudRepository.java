package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.business.cybord.entities.AtributoSolicitud;
import com.business.cybord.entities.Solicitud;
import com.business.cybord.entities.Usuario;

public interface AtributoSolicitudRepository extends CrudRepository<AtributoSolicitud, Integer>{
	List<AtributoSolicitud> findBySolicitud(Solicitud dto);
	Optional<AtributoSolicitud> findBySolicitudAndId(Solicitud u, int id);
}
