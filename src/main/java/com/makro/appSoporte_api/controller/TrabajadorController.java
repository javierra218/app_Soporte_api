package com.makro.appSoporte_api.controller;

import com.makro.appSoporte_api.model.Trabajador;
import com.makro.appSoporte_api.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public Trabajador getTrabajadorById(@PathVariable Long id) {
        return trabajadorService.getTrabajadorById(id);
    }

    @PostMapping
    public Trabajador createTrabajador(@RequestBody Trabajador trabajador) {
        return trabajadorService.createTrabajador(trabajador);
    }

    @PutMapping("/{id}")
    public Trabajador updateTrabajador(@PathVariable Long id, @RequestBody Trabajador trabajador) {
        return trabajadorService.updateTrabajador(id, trabajador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrabajador(@PathVariable Long id) {
        return ResponseEntity.ok(trabajadorService.deleteTrabajador(id));
    }

    

    @PostMapping("/reset")
    public void resetPesosAcumulados() {
        trabajadorService.resetPesosAcumulados();
    }


    // @GetMapping("/max-peso")
    // public ResponseEntity<Trabajador> getTrabajadorConMaxPeso() {
    //     Trabajador trabajador = trabajadorService.getTrabajadorConMaxPeso();
    //     return new ResponseEntity<>(trabajador, HttpStatus.OK);
    // }

    // @GetMapping("/min-peso")
    // public ResponseEntity<Trabajador> getTrabajadorConMinPeso() {
    //     Trabajador trabajador = trabajadorService.getTrabajadorConMinPeso();
    //     return new ResponseEntity<>(trabajador, HttpStatus.OK);
    // }
}
