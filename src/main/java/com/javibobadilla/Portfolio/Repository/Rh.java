package com.javibobadilla.Portfolio.Repository;

import com.javibobadilla.Portfolio.Entity.h;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Rh extends JpaRepository<h, Integer>{
    Optional<h> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}

