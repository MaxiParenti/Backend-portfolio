/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mnp.controller;

import com.portfolio.mnp.dto.dtoEdu;
import com.portfolio.mnp.entity.educacion;
import com.portfolio.mnp.security.controller.Mensaje;
import com.portfolio.mnp.service.sEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
//fix
@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://frontendmnp.web.app")
public class cEdu {
    @Autowired
    sEducacion SEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<educacion>> list(){
        List<educacion> list = SEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
       
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEdu DtoEdu){
        if(StringUtils.isBlank(DtoEdu.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (SEducacion.existByNombreE (DtoEdu.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa Educacion ya existe"), HttpStatus.BAD_REQUEST);
        
        educacion Educacion  = new educacion(DtoEdu.getNombreE(), DtoEdu.getDescripcionE());
        SEducacion.save(Educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
        }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id")int id, @RequestBody dtoEdu DtoEdu){
    //validar id's
        if(!SEducacion.existById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
    //compara los nombres para saber si se repite
        if(SEducacion.existByNombreE(DtoEdu.getNombreE()) && SEducacion.getByNombreE(DtoEdu.getNombreE()).get().getId()!= id)
        return new ResponseEntity(new Mensaje("Esa Educacion ya existe"), HttpStatus.BAD_REQUEST);
    //no tiene que estar vacio
        if(StringUtils.isBlank(DtoEdu.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    
    educacion Educacion = SEducacion.getOne(id).get();
    Educacion.setNombreE(DtoEdu.getNombreE());
    Educacion.setDescripcionE(DtoEdu.getDescripcionE());
    
    SEducacion.save(Educacion);
    return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        //validar id's
        if(!SEducacion.existById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        SEducacion.deleteById(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    

    @GetMapping("/detail/{id}")
    public ResponseEntity<educacion>getById(@PathVariable("id") int id){
        if(!SEducacion.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        educacion Educacion = SEducacion.getOne(id).get();
        return new ResponseEntity(Educacion, HttpStatus.OK);
    }
}
