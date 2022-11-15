package com.portfolio.mnp.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.mnp.security.entity.Rol;
import com.portfolio.mnp.security.enums.RolNombre;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
//fix