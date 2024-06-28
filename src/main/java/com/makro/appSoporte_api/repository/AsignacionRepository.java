package com.makro.appSoporte_api.repository;

import com.makro.appSoporte_api.model.Asignacion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {

    @Query("SELECT a FROM Asignacion a WHERE a.trabajador.id_trabajador = ?1")
    public List<Asignacion> findByTrabajadorIdTrabajador(Long id_trabajador);

}
