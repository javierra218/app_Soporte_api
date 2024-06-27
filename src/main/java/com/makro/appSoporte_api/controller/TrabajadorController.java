package com.makro.appSoporte_api.controller;

import com.makro.appSoporte_api.model.Trabajador;
import com.makro.appSoporte_api.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/trabajadores")
public class TrabajadorController {
    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping
    public List<Trabajador> getAllTrabajadores() {
        return trabajadorService.getAllTrabajadores();
    }

    @PostMapping
    public Trabajador createTrabajador(@RequestBody Trabajador trabajador) {
        return trabajadorService.createTrabajador(trabajador);
    }

    @PutMapping("/{id}")
    public Trabajador updateTrabajador(@PathVariable Long id, @RequestBody Trabajador trabajador) {
        return trabajadorService.updateTrabajador(id, trabajador);
    }

    @PostMapping("/reset")
    public void resetPesosAcumulados() {
        trabajadorService.resetPesosAcumulados();
    }
}
