package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.entities.AtributoSolicitud;

@Repository
public interface AtributoSolicitudRepository extends JpaRepository<AtributoSolicitud, Integer>{
	
	@Query("select a from AtributoSolicitud as a where a.solicitud.id=:idS and a.id=:id")
	Optional<AtributoSolicitud> findByIdSolicitudAndId(@Param("idS")int idS,@Param("id")int id);
	@Query("select a from AtributoSolicitud as a where a.solicitud.id=:idS")
	List<AtributoSolicitud> findByIdSolicitud(@Param("idS") int idS);
}
