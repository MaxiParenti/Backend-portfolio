/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.mnp.repository;

import com.portfolio.mnp.entity.educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
public interface rEducacion extends JpaRepository<educacion, Integer>{
    public Optional <educacion> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
