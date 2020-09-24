package com.business.cybord.repositories;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.entities.SaldoAhorro;

@Repository
public interface SaldoAhorroRepository extends JpaRepository<SaldoAhorro, Integer> {
	
	public List<SaldoAhorro> findByIdUsuario(Integer idUsuario);
	
	@Query("select s from SaldoAhorro s where s.id = :id_ahorro and s.idUsuario = :id_usuario")
	public Optional<SaldoAhorro> findByIdUsuarioAndId( @Param("id_usuario") Integer idUsuario, @Param("id_ahorro") Integer idSaldo);

	@Query("select p from SaldoAhorro p, Usuario u WHERE upper(u.nombre) like upper(:nombre) AND upper(u.email) like upper(:email) and p.idUsuario = u.id and p.fechaCreacion between :since and :to")
	public Page<SaldoAhorro> findAllByParams(@Param("nombre") String nombre, @Param("email") String email, @Param("since") Date since, @Param("to") Date to,Pageable pageable);

}
