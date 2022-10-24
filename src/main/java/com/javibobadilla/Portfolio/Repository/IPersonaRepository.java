
package com.javibobadilla.Portfolio.Repository;

import com.javibobadilla.Portfolio.Entity.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long>{

    public List<Persona> findAll();
    
}
