package com.example.AD2_Vehiculos.repository;

import com.example.AD2_Vehiculos.entity.Vehiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

// O método save está implícito aqui
// Por eso solo temos un repositorio, pois o save sirve tanto para coche, como moto, etc
// E como heredamso de pageable

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    Page<Vehiculo> findAll(Pageable pageable); // Pageable encapsula a petición da páxina
    // Poñelo con JpaRepository é redundante porque xa hereda de Pagenosequé, ver si o hai que poñer con CrudRepository
    Optional<Vehiculo> findById(Long id);

    @Query ("SELECT CASE WHEN COUNT(v) > 0 THEN true ELSE false END FROM Vehiculo v WHERE v.idVehiculo = :idVehiculo AND TYPE(v) = :tipo")
    boolean existsByVehiculoAndVehiculoType(@Param("tipo") Class tipoVehiculo, Long idVehiculo);
}
