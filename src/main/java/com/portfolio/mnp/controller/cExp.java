/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mnp.controller;

import com.portfolio.mnp.dto.dtoExp;
import com.portfolio.mnp.entity.experiencia;
import com.portfolio.mnp.security.controller.Mensaje;
import com.portfolio.mnp.service.sExperiencia;
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
//fix

@RestController
@RequestMapping("/explab")
@CrossOrigin(origins = "https://frontendmnp.web.app")
public class cExp {
    @Autowired
    sExperiencia SExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<experiencia>> list(){
        List<experiencia> list = SExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExp DtoExp){
        if(StringUtils.isBlank(DtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (SExperiencia.existByNombreE (DtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa Experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        experiencia Experiencia  = new experiencia(DtoExp.getNombreE(), DtoExp.getDescripcionE());
        SExperiencia.save(Experiencia);
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
        }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id")int id, @RequestBody dtoExp DtoExp){
    //validar id's
        if(!SExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
    //compara los nombres para saber si se repite
        if(SExperiencia.existByNombreE(DtoExp.getNombreE()) && SExperiencia.getByNombreE(DtoExp.getNombreE()).get().getId()!= id)
        return new ResponseEntity(new Mensaje("Esa Experiencia ya existe"), HttpStatus.BAD_REQUEST);
    //no tiene que estar vacio
        if(StringUtils.isBlank(DtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    
    experiencia Experiencia = SExperiencia.getOne(id).get();
    Experiencia.setNombreE(DtoExp.getNombreE());
    Experiencia.setDescripcionE(DtoExp.getDescripcionE());
    
    SExperiencia.save(Experiencia);
    return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        //validar id's
        if(!SExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        SExperiencia.deleteById(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    

    @GetMapping("/detail/{id}")
    public ResponseEntity<experiencia>getById(@PathVariable("id") int id){
        if(!SExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        experiencia Experiencia = SExperiencia.getOne(id).get();
        return new ResponseEntity(Experiencia, HttpStatus.OK);
    }
}
