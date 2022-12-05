/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.mnp.repository;

/**
 *
 * @author PC
 */
import com.portfolio.mnp.entity.educacion;
import com.portfolio.mnp.entity.proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
public interface rProyecto extends JpaRepository<proyecto, Integer>{
    public Optional <proyecto> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
