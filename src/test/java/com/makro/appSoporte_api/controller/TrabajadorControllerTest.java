package com.makro.appSoporte_api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.makro.appSoporte_api.model.Trabajador;
import com.makro.appSoporte_api.service.TrabajadorService;

public class TrabajadorControllerTest {

    @Mock
    private TrabajadorService trabajadorService;

    @InjectMocks
    private TrabajadorController trabajadorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTrabajadores() {
        List<Trabajador> trabajadores = new ArrayList<>();
        // Agregar datos de prueba a la lista

        when(trabajadorService.getAllTrabajadores()).thenReturn(trabajadores);

        List<Trabajador> result = trabajadorController.getAllTrabajadores();

        assertEquals(trabajadores, result);
        verify(trabajadorService, times(1)).getAllTrabajadores();
    }

    @Test
    void testGetTrabajadorById() {
        Long id = 1L;
        Trabajador trabajador = new Trabajador();
        // Establecer datos de prueba para el objeto trabajador

        when(trabajadorService.getTrabajadorById(id)).thenReturn(trabajador);

        Trabajador result = trabajadorController.getTrabajadorById(id);

        assertEquals(trabajador, result);
        verify(trabajadorService, times(1)).getTrabajadorById(id);
    }

    @Test
    void testCreateTrabajador() {
        Trabajador trabajador = new Trabajador();
        // Establecer datos de prueba para el objeto trabajador

        when(trabajadorService.createTrabajador(trabajador)).thenReturn(trabajador);

        Trabajador result = trabajadorController.createTrabajador(trabajador);

        assertEquals(trabajador, result);
        verify(trabajadorService, times(1)).createTrabajador(trabajador);
    }

    @Test
    void testUpdateTrabajador() {
        Long id = 1L;
        Trabajador trabajador = new Trabajador();
        // Establecer datos de prueba para el objeto trabajador

        when(trabajadorService.updateTrabajador(id, trabajador)).thenReturn(trabajador);

        Trabajador result = trabajadorController.updateTrabajador(id, trabajador);

        assertEquals(trabajador, result);
        verify(trabajadorService, times(1)).updateTrabajador(id, trabajador);
    }

    @Test
    void testDeleteTrabajador() {
        Long id = 1L;
        String expectedResponse = "Trabajador deleted successfully";

        when(trabajadorService.deleteTrabajador(id)).thenReturn(expectedResponse);

        ResponseEntity<String> result = trabajadorController.deleteTrabajador(id);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(expectedResponse, result.getBody());
        verify(trabajadorService, times(1)).deleteTrabajador(id);
    }

    @Test
    void testResetPesosAcumulados() {
        trabajadorController.resetPesosAcumulados();
        verify(trabajadorService, times(1)).resetPesosAcumulados();
    }

}
