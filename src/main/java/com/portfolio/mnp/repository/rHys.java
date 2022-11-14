/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.mnp.repository;

import com.portfolio.mnp.entity.hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author PC
 */

public interface rHys extends JpaRepository<hys, Integer>{
    Optional<hys> findByNombre(String nombre);
    
    public boolean existByNombre(String nombre);
}
