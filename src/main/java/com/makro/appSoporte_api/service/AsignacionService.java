package com.makro.appSoporte_api.service;

import com.makro.appSoporte_api.exception.ResourceNotFoundException;
import com.makro.appSoporte_api.model.Asignacion;
import com.makro.appSoporte_api.model.Soporte;
import com.makro.appSoporte_api.model.Trabajador;
import com.makro.appSoporte_api.repository.AsignacionRepository;
import com.makro.appSoporte_api.repository.SoporteRepository;
import com.makro.appSoporte_api.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AsignacionService {
    @Autowired
    private AsignacionRepository asignacionRepository;

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    private SoporteRepository soporteRepository;

    public Asignacion assignSupport(Soporte soporte) {
        // Guardar la entidad Soporte
        Soporte savedSoporte = soporteRepository.save(soporte);

        // Obtener lista de trabajadores
        List<Trabajador> trabajadores = trabajadorRepository.findAll();
        if (trabajadores.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron trabajadores");
        }

        // Encontrar el trabajador con menor peso acumulado
        Trabajador trabajador = seleccionarTrabajadorConMenorPeso(trabajadores);

        // Crear y guardar la entidad Asignacion
        Asignacion asignacion = crearGuardarAsignacion(savedSoporte, trabajador);

        return asignacion;
    }

    private Trabajador seleccionarTrabajadorConMenorPeso(List<Trabajador> trabajadores) {
        trabajadores.sort((t1, t2) -> t1.getPeso_acumulado().compareTo(t2.getPeso_acumulado()));
        int minPeso = trabajadores.get(0).getPeso_acumulado();

        List<Trabajador> candidatos = trabajadores.stream()
                .filter(t -> t.getPeso_acumulado() == minPeso)
                .toList();

        return candidatos.get(new Random().nextInt(candidatos.size()));
    }

    private Asignacion crearGuardarAsignacion(Soporte soporte, Trabajador trabajador) {
        trabajador.setPeso_acumulado(trabajador.getPeso_acumulado() + soporte.getPeso_trabajo());
        trabajadorRepository.save(trabajador);

        Asignacion asignacion = new Asignacion();
        asignacion.setTrabajador(trabajador);
        asignacion.setSoporte(soporte);

        return asignacionRepository.save(asignacion);
    }
}
