package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.business.cybord.models.entities.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer>,JpaSpecificationExecutor<Solicitud> {

	@Query("select s from Solicitud as s where s.usuario.id=:idU")
	List<Solicitud> findUsuario(int idU);
	
	
	Page<Solicitud> findAll(Pageable pageable);

	@Query("select s from Solicitud as s where s.usuario.id=:idU and s.id=:id ")
	Optional<Solicitud> findByIdUsuarioAndId(int idU, int id);

}
