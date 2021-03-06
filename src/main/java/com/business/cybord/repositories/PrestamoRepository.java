package com.business.cybord.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.business.cybord.models.entities.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

	public List<Prestamo> findByIdDeudor(Integer idDeudor);
	//TODO: Cambiar hardcodeado por enum
	@Query("select e from Prestamo e where e.idDeudor = :idDeudor and e.estatus in ('ACTIVO','SUSPENDIDO','TRASPASADO')")
	public List<Prestamo> findByIdDeudorNotCompleted(Integer idDeudor);
	
	@Query("select e from Prestamo e where e.idDeudor = :idDeudor and e.estatus in ('ACTIVO','SUSPENDIDO')")
	public List<Prestamo> findByIdDeudorActivoSuspendido (Integer idDeudor);
	
	
	public Optional<Prestamo> findByIdAndIdDeudor(Integer idPrestamo, Integer idDeudor);

	@Query("select e from Prestamo e inner join SaldoPrestamo s on s.idPrestamo = e.id where e.idDeudor = :idUsuario and e.id = :idPrestamo and s.idPrestamo = :idSaldo")
	public Optional<Prestamo> findByIdAndIdDeudorAndIdSaldo(@Param("idUsuario") Integer idUsuario,
			@Param("idPrestamo") Integer idPrestamo, @Param("idSaldo") Integer idSaldo);

	@Query("SELECT e FROM Prestamo e WHERE e.estatus = 'ACTIVO' or e.estatus = 'TRASPASADO'")
	List<Prestamo> findActivoTraspasado();
	
}
