package com.business.cybord.repositories;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.business.cybord.entities.Prestamo;


public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
	
	
	public List<Prestamo> findByIdDeudor(Integer idDeudor);
	
	public Optional<Prestamo> findByIdAndIdDeudor(Integer idPrestamo,Integer idDeudor);
	
	@Query("select e from Prestamo e inner join SaldoPrestamo s on s.idPrestamo = e.id where e.idDeudor = :idUsuario and e.id = :idPrestamo and s.idPrestamo = :idSaldo")
	public Optional<Prestamo> findByIdAndIdDeudorAndIdSaldo(@Param("idUsuario") Integer idUsuario, @Param("idPrestamo")Integer idPrestamo, @Param("idSaldo") Integer idSaldo);
	
	@Query("select p from Prestamo p, Usuario u WHERE upper(u.nombre) like upper(:nombre) AND upper(u.email) like upper(:email) and p.idDeudor = u.id and p.fechaCreacion between :since and :to")
	public Page<Prestamo> findAllByParams(@Param("nombre") String nombre, @Param("email") String email, @Param("since") Date since, @Param("to") Date to,Pageable pageable);

}
