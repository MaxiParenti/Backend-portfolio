package com.portfolio.mnp.security.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Mensaje {
    private String mensaje;

    //constuctor vacio
    public Mensaje() {
    }
    //constructor con parametros
    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

   

    
    
}