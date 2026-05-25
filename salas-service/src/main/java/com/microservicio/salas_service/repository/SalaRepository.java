package com.microservicio.salas_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservicio.salas_service.model.Sala;


@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{

    List<Sala> findByTipo(String tipo);

    List<Sala> findByCineId(Long cineId);
    
}
