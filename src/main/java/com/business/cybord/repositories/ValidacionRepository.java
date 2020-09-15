package com.business.cybord.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.business.cybord.entities.Solicitud;
import com.business.cybord.entities.Validacion;


public interface ValidacionRepository  extends CrudRepository<Validacion, Integer>{
	List<Validacion> findBySolicitud(Solicitud dto);
}
