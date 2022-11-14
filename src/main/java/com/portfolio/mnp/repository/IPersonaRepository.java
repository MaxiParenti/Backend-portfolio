package com.portfolio.mnp.repository;

import com.portfolio.mnp.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
        
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
    

}
