package com.portfolio.mnp.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.mnp.security.entity.Usuario;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    
}
//fix