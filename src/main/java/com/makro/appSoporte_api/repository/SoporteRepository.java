package com.makro.appSoporte_api.repository;

import com.makro.appSoporte_api.model.Soporte;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SoporteRepository extends JpaRepository<Soporte, Long> {

    @Query("SELECT s FROM Soporte s WHERE s.prioridad = ?1")
    List<Soporte> findByPrioridad(Integer prioridad);

}
