
package com.javibobadilla.Portfolio.Interface;

import com.javibobadilla.Portfolio.Entity.Persona;
import java.util.List;

public interface IPersonaService {

    public List<Persona> getPersona();//me trae una lista de personas(get)
    
    public void savePersona(Persona persona);//guardo un objeto de tipo persona
    
    public void deletePersona(Long id);//elimino un objeto por ID
    
    public Persona findPersona(Long id);//buscar una pesona por ID

}
