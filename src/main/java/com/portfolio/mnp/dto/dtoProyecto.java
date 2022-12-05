/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mnp.dto;

/**
 *
 * @author PC
 */
import javax.validation.constraints.NotBlank;

/**
 *
 * @author PC
 */
public class dtoProyecto {
    @NotBlank
    String nombre;
    @NotBlank
    String descripcion;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
