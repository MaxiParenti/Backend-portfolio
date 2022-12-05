/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mnp.controller;

/**
 *
 * @author PC
 */
import com.portfolio.mnp.dto.dtoEdu;
import com.portfolio.mnp.dto.dtoProyecto;
import com.portfolio.mnp.entity.educacion;
import com.portfolio.mnp.entity.proyecto;
import com.portfolio.mnp.security.controller.Mensaje;
import com.portfolio.mnp.service.sProyecto;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "https://frontendmnp.web.app")
public class cProyecto {
    @Autowired
    sProyecto sproyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<proyecto>> list(){
        List<proyecto> list = sproyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
       
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtop){
        if(StringUtils.isBlank(dtop.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (sproyecto.existByNombre (dtop.getNombre()))
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        proyecto Proyecto  = new proyecto(dtop.getNombre(), dtop.getDescripcion());
        sproyecto.save(Proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
        }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id")int id, @RequestBody dtoProyecto dtop){
    //validar id's
        if(!sproyecto.existById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
    //compara los nombres para saber si se repite
        if(sproyecto.existByNombre(dtop.getNombre()) && sproyecto.getByNombre(dtop.getNombre()).get().getId()!= id)
        return new ResponseEntity(new Mensaje("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);
    //no tiene que estar vacio
        if(StringUtils.isBlank(dtop.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    
    proyecto Proyecto = sproyecto.getOne(id).get();
    Proyecto.setNombre(dtop.getNombre());
    Proyecto.setDescripcion(dtop.getDescripcion());
    
    sproyecto.save(Proyecto);
    return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);
    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        //validar id's
        if(!sproyecto.existById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        sproyecto.deleteById(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminada"), HttpStatus.OK);
    }
    

    @GetMapping("/detail/{id}")
    public ResponseEntity<educacion>getById(@PathVariable("id") int id){
        if(!sproyecto.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        proyecto Proyecto = sproyecto.getOne(id).get();
        return new ResponseEntity(Proyecto, HttpStatus.OK);
    }
}
