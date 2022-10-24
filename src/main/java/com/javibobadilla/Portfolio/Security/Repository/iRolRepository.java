
package com.javibobadilla.Portfolio.Security.Repository;

import com.javibobadilla.Portfolio.Security.Entity.Rol;
import com.javibobadilla.Portfolio.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);    
}
