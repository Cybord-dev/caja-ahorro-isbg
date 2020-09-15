package com.business.cybord.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.business.cybord.entities.AtributoSolicitud;
import com.business.cybord.entities.Solicitud;

public interface AtributoSolicitudRepository extends CrudRepository<AtributoSolicitud, Integer>{
	List<AtributoSolicitud> findBySolicitud(Solicitud dto);
}
