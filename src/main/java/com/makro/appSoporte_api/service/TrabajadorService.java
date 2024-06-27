package com.makro.appSoporte_api.service;

import com.makro.appSoporte_api.model.Trabajador;
import com.makro.appSoporte_api.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorService {
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    public List<Trabajador> getAllTrabajadores() {
        return trabajadorRepository.findAll();
    }

    public Trabajador createTrabajador(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador updateTrabajador(Long id, Trabajador trabajador) {
        Trabajador existingTrabajador = trabajadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Trabajador not found"));
        existingTrabajador.setNombre_trabajador(trabajador.getNombre_trabajador());
        existingTrabajador.setPeso_acumulado(trabajador.getPeso_acumulado());
        return trabajadorRepository.save(existingTrabajador);
    }

    public void resetPesosAcumulados() {
        List<Trabajador> trabajadores = trabajadorRepository.findAll();
        for (Trabajador trabajador : trabajadores) {
            trabajador.setPeso_acumulado(0);
        }
        trabajadorRepository.saveAll(trabajadores);
    }
}
