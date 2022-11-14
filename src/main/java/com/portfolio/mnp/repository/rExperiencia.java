/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.mnp.repository;

import com.portfolio.mnp.entity.experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rExperiencia extends JpaRepository<experiencia, Integer>{
    public Optional <experiencia> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
