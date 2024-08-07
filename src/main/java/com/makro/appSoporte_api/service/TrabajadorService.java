package com.makro.appSoporte_api.service;

import com.makro.appSoporte_api.exception.ResourceNotFoundException;
import com.makro.appSoporte_api.model.Asignacion;
import com.makro.appSoporte_api.model.Trabajador;
import com.makro.appSoporte_api.repository.AsignacionRepository;
import com.makro.appSoporte_api.repository.TrabajadorRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// import java.util.Comparator;

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
                .orElseThrow(() -> new ResourceNotFoundException("Id Trabajador: " + id));
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

    @Transactional
    public String deleteTrabajador(Long id) {
        Trabajador trabajador = trabajadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id Trabajador: " + id));
        List<Asignacion> asignaciones = asignacionRepository.findByTrabajadorIdTrabajador(id);
        if (!asignaciones.isEmpty()) {
            return "No se puede eliminar el trabajador con ID " + id + " porque tiene asignaciones asociadas.";
        }
        trabajadorRepository.delete(trabajador);
        return "Trabajador con ID " + id + " eliminado con éxito.";
    }

    public void resetPesosAcumulados() {
        List<Trabajador> trabajadores = trabajadorRepository.findAll();
        trabajadores.forEach(trabajador -> trabajador.setPeso_acumulado(0));
        trabajadorRepository.saveAll(trabajadores);
    }

    // public Trabajador getTrabajadorConMaxPeso() {
    // return trabajadorRepository.findAll()
    // .stream()
    // .max(Comparator.comparingInt(Trabajador::getPeso_acumulado))
    // .orElse(null);
    // }

    // public Trabajador getTrabajadorConMinPeso() {
    // return trabajadorRepository.findAll()
    // .stream()
    // .min(Comparator.comparingInt(Trabajador::getPeso_acumulado))
    // .orElse(null);
    // }

}
