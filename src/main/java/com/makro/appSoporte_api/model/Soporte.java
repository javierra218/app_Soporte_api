package com.makro.appSoporte_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "soportes")
public class Soporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_soporte;

    @Column(name = "nombre_soporte")
    private String nombre_soporte;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "prioridad")
    private Integer prioridad;

    @Column(name = "peso_trabajo")
    private Integer peso_trabajo;

    // Getters y Setters
    public Long getId_soporte() {
        return id_soporte;
    }

    public void setId_soporte(Long id_soporte) {
        this.id_soporte = id_soporte;
    }

    public String getNombre_soporte() {
        return nombre_soporte;
    }

    public void setNombre_soporte(String nombre_soporte) {
        this.nombre_soporte = nombre_soporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Integer getPeso_trabajo() {
        return peso_trabajo;
    }

    public void setPeso_trabajo(Integer peso_trabajo) {
        this.peso_trabajo = peso_trabajo;
    }
}
