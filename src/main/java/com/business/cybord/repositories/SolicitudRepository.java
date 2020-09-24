package com.business.cybord.repositories;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.business.cybord.models.entities.Solicitud;


public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
	List<Solicitud> findByIdUsuario(int idU);

	List<Solicitud> findAll();

	Optional<Solicitud> findByIdUsuarioAndId(int idU, int id);

	@Query("select s from Solicitud s, Usuario u where upper(u.email) like upper(:email) AND s.idUsuario = u.id AND u.activo = 1  AND s.fechaCreacion BETWEEN :since AND :to")
	Page<Solicitud> findByEmail(@Param("email") String email, @Param("since") Date since,@Param("to") Date to ,Pageable pageable);
	
	@Query("select s from Solicitud s, Usuario u where upper(u.email) like upper(:email) AND s.idUsuario = u.id AND s.tipo = :tipo AND s.fechaCreacion BETWEEN :since AND :to AND u.activo = 1")
	Page<Solicitud> findByParams(@Param("email") String email, @Param("tipo") int tipo, @Param("since") Date since,@Param("to") Date to ,Pageable pageable);

	@Query("select s from Solicitud s, Usuario u where upper(u.email) like upper(:email) AND s.idUsuario = u.id AND s.tipo = :tipo AND s.estatus = :estatus AND s.fechaCreacion BETWEEN :since AND :to AND u.activo = 1")
	Page<Solicitud> findByParams(@Param("email") String email, @Param("tipo") int tipo, @Param("estatus") int estatus, @Param("since") Date since,@Param("to") Date to ,Pageable pageable);
	
	@Query("select s from Solicitud s, Usuario u where s.tipo = :tipo AND s.fechaCreacion BETWEEN :since AND :to AND u.activo = 1")
	Page<Solicitud> findByParams( @Param("tipo") int tipo, @Param("since") Date since,@Param("to") Date to ,Pageable pageable);
	
	@Query("select s from Solicitud s where s.tipo = :tipo AND s.estatus = :estatus AND s.fechaCreacion BETWEEN :since AND :to")
	Page<Solicitud> findByParams( @Param("tipo") int tipo,@Param("estatus") int estatus, @Param("since") Date since,@Param("to") Date to ,Pageable pageable);
	
	@Query("select s from Solicitud s where  s.estatus = :estatus AND s.fechaCreacion BETWEEN :since AND :to")
	Page<Solicitud> findByEstatus(@Param("estatus") int estatus, @Param("since") Date since,@Param("to") Date to ,Pageable pageable);
	
	@Query("select s from Solicitud s where s.fechaCreacion BETWEEN :since AND :to")
	Page<Solicitud> findByParams( @Param("since") Date since,@Param("to") Date to ,Pageable pageable);
}
