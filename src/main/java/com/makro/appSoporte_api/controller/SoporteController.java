package com.makro.appSoporte_api.controller;

import com.makro.appSoporte_api.model.Soporte;
import com.makro.appSoporte_api.service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soportes")
public class SoporteController {
    @Autowired
    private SoporteService soporteService;

    @GetMapping
    public List<Soporte> getAllSoportes() {
        return soporteService.getAllSoportes();
    }

    @GetMapping("/{id}")
    public Soporte getSoporteById(@PathVariable Long id) {
        return soporteService.getSoporteById(id);
    }

    @PostMapping
    public Soporte createSoporte(@RequestBody Soporte soporte) {
        return soporteService.createSoporte(soporte);
    }

    @PutMapping("/{id}")
    public Soporte updateSoporte(@PathVariable Long id, @RequestBody Soporte soporte) {
        return soporteService.updateSoporte(id, soporte);
    }

    @DeleteMapping("/{id}")
    public void deleteSoporte(@PathVariable Long id) {
        soporteService.deleteSoporte(id);
    }



    

}
