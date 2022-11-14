package com.portfolio.mnp.Interface;

import com.portfolio.mnp.entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Traer Personas
    public List<Persona> getPersona();
    
    //Se guardan objeto Persona
    public void savePersona (Persona persona);
    
   //Eliminar objeto por ID
    public void deletePersona(Long id);
    
    //Encontrar objeto Persona
    public Persona findPersona(Long id);
}
