/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mnp.security.service;

import com.portfolio.mnp.entity.experiencia;
import com.portfolio.mnp.repository.rExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class sExperiencia {
    @Autowired
    rExperiencia RExperiencia;
    
    public List<experiencia> list(){
        return RExperiencia.findAll();
    }
    
    public Optional<experiencia> getOne(int id){
        return RExperiencia.findById(id);
    }
    
    public Optional<experiencia> getByNombreE(String nombreE){
        return RExperiencia.findByNombreE(nombreE);
    }
    
    public void save(experiencia exp){
        RExperiencia.save(exp);
    }
    
    public void deleteById(int id){
        RExperiencia.deleteById(id);
    }
    
    public boolean existById(int id){
        return RExperiencia.existsById(id);
    }
    
    public boolean existByNombreE(String nombreE){
        return RExperiencia.existsByNombreE(nombreE);
    }
}
