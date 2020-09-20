package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.business.cybord.entities.Solicitud;


public interface SolicitudRepository extends JpaRepository<Solicitud, Integer>{
	List<Solicitud> findByIdUsuario(int idU);
	Optional<Solicitud> findByIdUsuarioAndId(int idU, int id);
}
