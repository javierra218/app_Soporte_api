package com.makro.appSoporte_api.service;

import com.makro.appSoporte_api.exception.ResourceNotFoundException;
import com.makro.appSoporte_api.model.Asignacion;
import com.makro.appSoporte_api.model.Trabajador;
import com.makro.appSoporte_api.repository.AsignacionRepository;
import com.makro.appSoporte_api.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorService {
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    private AsignacionRepository asignacionRepository;

    public List<Trabajador> getAllTrabajadores() {
        return trabajadorRepository.findAll();
    }

    public Trabajador getTrabajadorById(Long id) {
        return trabajadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id Trabajador:" + id));
    }

    public Trabajador createTrabajador(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador updateTrabajador(Long id, Trabajador trabajador) {
        Trabajador existingTrabajador = trabajadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id Trabajador: " + id));
        existingTrabajador.setNombre_trabajador(trabajador.getNombre_trabajador());
        existingTrabajador.setPeso_acumulado(trabajador.getPeso_acumulado());
        return trabajadorRepository.save(existingTrabajador);
    }

    // Delete a trabajador
    public String deleteTrabajador(Long id) {
        trabajadorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id Trabajador: " + id));
        List<Asignacion> asignaciones = asignacionRepository.findByTrabajadorIdTrabajador(id);
        if (asignaciones.size() > 0) {
            return "No se puede eliminar el trabajador con ID " + id + " porque tiene asignaciones asociadas.";
        }
        trabajadorRepository.deleteById(id);
        return "Trabajador con ID " + id + " eliminado con éxito.";
    }

    

    public void resetPesosAcumulados() {
        List<Trabajador> trabajadores = trabajadorRepository.findAll();
        for (Trabajador trabajador : trabajadores) {
            trabajador.setPeso_acumulado(0);
        }
        trabajadorRepository.saveAll(trabajadores);
    }

    
}
