/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mnp.service;

/**
 *
 * @author PC
 */
import com.portfolio.mnp.entity.proyecto;
import com.portfolio.mnp.repository.rProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
@Transactional
public class sProyecto {
    @Autowired
    rProyecto rproyecto;
    
public List<proyecto> list(){
        return rproyecto.findAll();
    }
    
    public Optional<proyecto> getOne(int id){
        return rproyecto.findById(id);
    }
    
    public Optional<proyecto> getByNombre(String nombre){
        return rproyecto.findByNombre(nombre);
    }
    
    public void save(proyecto pr){
        rproyecto.save(pr);
    }
    
    public void deleteById(int id){
        rproyecto.deleteById(id);
    }
    
    public boolean existById(int id){
        return rproyecto.existsById(id);
    }
    
    public boolean existByNombre(String nombre){
        return rproyecto.existsByNombre(nombre);
    }
}

