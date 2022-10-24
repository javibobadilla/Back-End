package com.javibobadilla.Portfolio.Service;

import com.javibobadilla.Portfolio.Entity.h;
import com.javibobadilla.Portfolio.Repository.Rh;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class Sh {
    @Autowired
    Rh rh;
    
    public List<h> list(){
        return rh.findAll();
    }
    
    public Optional<h> getOne(int id){
        return rh.findById(id);
    }
    
    public Optional<h> getByNombre(String nombre){
        return rh.findByNombre(nombre);
    }
    
    public void save(h skill){
        rh.save(skill);
    }
    
    public void delete(int id){
        rh.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rh.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rh.existsByNombre(nombre);
    }
}