package com.business.cybord.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.cybord.entities.AtributoSolicitud;

@Repository
public interface AtributoSolicitudRepository extends JpaRepository<AtributoSolicitud, Integer>{
	Optional<AtributoSolicitud> findByIdSolicitudAndId(int ids, int id);
}
