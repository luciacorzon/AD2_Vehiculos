package com.example.AD2_Vehiculos.repository;

import com.example.AD2_Vehiculos.dto.VehiculoDTO;
import com.example.AD2_Vehiculos.entity.Vehiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

// O método save está implícito aqui
// Por eso solo temos un repositorio, pois o save sirve tanto para coche, como moto, etc
// E como heredamso de pageable

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // 1. Método que devuelve los vehículos de una marca.
    List<Vehiculo> findByMarca(String marca);

    // 2. Método que devuelve todos los vehículos paginados (ya está incluido en JpaRepository)
    Page<Vehiculo> findAll(Pageable pageable); // Pageable encapsula a petición da páxina
    // Poñelo con JpaRepository é redundante porque xa hereda de Pagenosequé, ver si o hai que poñer con CrudRepository
    Optional<Vehiculo> findById(Long id);

    // 3. Método que verifica si existe un vehículo con un id y un tipo de vehículo concreto
    @Query("SELECT CASE WHEN COUNT(v) > 0 THEN true ELSE false END FROM Vehiculo v WHERE v.idVehiculo = :idVehiculo AND TYPE(v) = :tipo")
    boolean existsByVehiculoAndVehiculoType(@Param("tipo") Class tipoVehiculo, Long idVehiculo);
    // TYPE(v) comproba de qué clase é o obxecto, si MOTO ou COCHE

    // 4. Método que devuelve un VehiculoDTO con campos específicos (idVehiculo, marca, modelo, año, precio, propietario)
    @Query("SELECT new com.example.AD2_Vehiculos.dto.VehiculoDTO(v.idVehiculo, v.marca, v.modelo, v.anio, v.precio, v.propietario) " +
            "FROM Vehiculo v JOIN FETCH v.propietario WHERE v.idVehiculo = :idVehiculo")
    VehiculoDTO findVehiculoDTOById(@Param("idVehiculo") Long idVehiculo);

    // 5. Método que devuelve todos los vehículos en formato VehiculoDTO, paginados y ordenados
    @Query("SELECT new com.example.AD2_Vehiculos.dto.VehiculoDTO(v.idVehiculo, v.marca, v.modelo, v.anio, v.precio, v.propietario) " +
            "FROM Vehiculo v JOIN FETCH v.propietario ORDER BY v.marca ASC, v.anio DESC")
    Page<VehiculoDTO> findAllVehiculosDTO(Pageable pageable);
}
