package com.business.cybord.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.business.cybord.models.entities.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer>, JpaSpecificationExecutor<Usuario> {

	Optional<Usuario> findById(int id);
	
	Optional<Usuario> findByNoEmpleado(String id);

	Optional<Usuario> findByEmail(String email);

	Page<Usuario> findAll(Pageable pageable);

}
