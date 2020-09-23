package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.business.cybord.entities.Solicitud;
import com.business.cybord.entities.Validacion;

@Repository
public interface ValidacionRepository  extends JpaRepository<Validacion, Integer>{
	List<Validacion> findBySolicitud(Solicitud dto);
	List<Validacion> findByIdSolicitud(int id);
	Optional<Validacion> findById(int id);
}
