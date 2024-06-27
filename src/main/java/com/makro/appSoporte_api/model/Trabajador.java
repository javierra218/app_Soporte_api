package com.makro.appSoporte_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trabajadores")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_trabajador;

    @Column(name = "nombre_trabajador")
    private String nombre_trabajador;

    @Column(name = "peso_acumulado")
    private Integer peso_acumulado;

    // Getters y Setters
    public Long getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(Long id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getNombre_trabajador() {
        return nombre_trabajador;
    }

    public void setNombre_trabajador(String nombre_trabajador) {
        this.nombre_trabajador = nombre_trabajador;
    }

    public Integer getPeso_acumulado() {
        return peso_acumulado;
    }

    public void setPeso_acumulado(Integer peso_acumulado) {
        this.peso_acumulado = peso_acumulado;
    }
}
