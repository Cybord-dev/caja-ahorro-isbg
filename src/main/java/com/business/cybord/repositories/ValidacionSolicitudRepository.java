package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.entities.Solicitud;
import com.business.cybord.models.entities.ValidacionSolicitud;

@Repository
public interface ValidacionSolicitudRepository  extends JpaRepository<ValidacionSolicitud, Integer>{
	
	List<ValidacionSolicitud> findBySolicitud(Solicitud dto);
	
	@Query("select v from ValidacionSolicitud as v where v.solicitud.id=:idU")
	List<ValidacionSolicitud> findByIdSolicitud(@Param("idU") Integer idU);
	
	Optional<ValidacionSolicitud> findById(int id);
}
