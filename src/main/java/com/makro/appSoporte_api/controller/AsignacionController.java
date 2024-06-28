package com.makro.appSoporte_api.controller;

import com.makro.appSoporte_api.model.Asignacion;
import com.makro.appSoporte_api.model.Soporte;
import com.makro.appSoporte_api.service.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asignaciones")
public class AsignacionController {
    @Autowired
    private AsignacionService asignacionService;

    @PostMapping("/assign")
    public Asignacion assignSupport(@RequestBody Soporte soporte) {
        return asignacionService.assignSupport(soporte);
    }

    @PostMapping("/assign/{trabajadorId}")
    public Asignacion assignSupportToSpecificWorker(@RequestBody Soporte soporte, @PathVariable Long trabajadorId) {
        return asignacionService.assignSupportToSpecificWorker(soporte, trabajadorId);
    }


    @PutMapping("/reasignar/{asignacionId}/{nuevoTrabajadorId}")
    public Asignacion reasignarSoporte(@PathVariable Long asignacionId, @PathVariable Long nuevoTrabajadorId) {
        return asignacionService.reasignarSoporte(asignacionId, nuevoTrabajadorId);
    }
}
