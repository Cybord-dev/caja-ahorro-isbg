package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.entities.DatosUsuario;

@Repository
public interface DatosUsuarioRepository extends JpaRepository<DatosUsuario, Integer> {

	public Optional<DatosUsuario> findById(String id);

	@Query("select e from DatosUsuario e where e.usuario.id = :idUsuario")
	public List<DatosUsuario> findByIdUsuario(@Param("idUsuario") Integer idUsuario);

	public Optional<DatosUsuario> findByTipoDato(String tipoDato);

	@Query("select e from DatosUsuario e where e.usuario.id = :idUsuario and e.tipoDato = :tipoDato")
	public Optional<DatosUsuario> findByTipoDatoAndIdUsuario(@Param("tipoDato") String tipoDato,
			@Param("idUsuario") Integer idUsuario);
}
