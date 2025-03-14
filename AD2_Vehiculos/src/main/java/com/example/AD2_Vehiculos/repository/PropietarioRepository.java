package com.example.AD2_Vehiculos.repository;

import com.example.AD2_Vehiculos.entity.Propietario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
    Page<Propietario> findAll(Pageable pageable); // Pageable encapsula a petición da páxina
    // Poñelo con JpaRepository é redundante porque xa hereda de Pagenosequé, ver si o hai que poñer con CrudRepository
    Optional<Propietario> findById(Long id);

}
