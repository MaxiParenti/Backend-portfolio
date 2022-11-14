/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mnp.security.service;

import com.portfolio.mnp.entity.educacion;
import com.portfolio.mnp.repository.rEducacion;
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
public class sEducacion {
    @Autowired
    rEducacion REducacion;
    
public List<educacion> list(){
        return REducacion.findAll();
    }
    
    public Optional<educacion> getOne(int id){
        return REducacion.findById(id);
    }
    
    public Optional<educacion> getByNombreE(String nombreE){
        return REducacion.findByNombreE(nombreE);
    }
    
    public void save(educacion ed){
        REducacion.save(ed);
    }
    
    public void deleteById(int id){
        REducacion.deleteById(id);
    }
    
    public boolean existById(int id){
        return REducacion.existsById(id);
    }
    
    public boolean existByNombreE(String nombreE){
        return REducacion.existsByNombreE(nombreE);
    }
}
