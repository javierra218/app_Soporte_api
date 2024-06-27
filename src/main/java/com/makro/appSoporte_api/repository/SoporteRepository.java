package com.makro.appSoporte_api.repository;

import com.makro.appSoporte_api.model.Soporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoporteRepository extends JpaRepository<Soporte, Long> {
}
