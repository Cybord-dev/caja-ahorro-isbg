package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business.cybord.entities.SaldoAhorro;

@Repository
public interface SaldoAhorroRepository extends JpaRepository<SaldoAhorro, Integer> {
	
	public List<SaldoAhorro> findByIdUsuario(Integer idUsuario);
	
	@Query("select s from SaldoAhorro s where s.id = :id_ahorro and s.idUsuario = :id_usuario")
	public Optional<SaldoAhorro> findByIdUsuarioAndId( @Param("id_usuario") Integer idUsuario, @Param("id_ahorro") Integer idSaldo);

}
