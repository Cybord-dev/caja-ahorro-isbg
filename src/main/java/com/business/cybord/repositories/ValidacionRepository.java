package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.business.cybord.entities.Solicitud;
import com.business.cybord.entities.Usuario;
import com.business.cybord.entities.Validacion;


public interface ValidacionRepository  extends CrudRepository<Validacion, Integer>{
	List<Validacion> findBySolicitud(Solicitud dto);
	Optional<Validacion> findByUsuarioAndId(Usuario u, int id);
}
