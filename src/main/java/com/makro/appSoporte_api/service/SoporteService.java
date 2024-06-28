package com.makro.appSoporte_api.service;

import com.makro.appSoporte_api.exception.ResourceNotFoundException;
import com.makro.appSoporte_api.model.Soporte;
import com.makro.appSoporte_api.repository.SoporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoporteService {
    @Autowired
    private SoporteRepository soporteRepository;

    public List<Soporte> getAllSoportes() {
        return soporteRepository.findAll();
    }

    public Soporte getSoporteById(Long id) {
        return soporteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Soporte no encontrado"));
    }

    public Soporte createSoporte(Soporte soporte) {
        return soporteRepository.save(soporte);
    }

    public Soporte updateSoporte(Long id, Soporte soporte) {
        Soporte existingSoporte = soporteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Soporte not found"));
        existingSoporte.setNombre_soporte(soporte.getNombre_soporte());
        existingSoporte.setDescripcion(soporte.getDescripcion());
        existingSoporte.setPrioridad(soporte.getPrioridad());
        existingSoporte.setPeso_trabajo(soporte.getPeso_trabajo());
        return soporteRepository.save(existingSoporte);
    }

    public void deleteSoporte(Long id) {
        Soporte existingSoporte = soporteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Soporte no encontrado"));
        soporteRepository.delete(existingSoporte);
    }
    

}
