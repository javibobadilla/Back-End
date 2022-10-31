package com.javibobadilla.Portfolio.Controller;

import com.javibobadilla.Portfolio.Dto.dtoH;
import com.javibobadilla.Portfolio.Entity.h;
import com.javibobadilla.Portfolio.Security.Controller.Mensaje;
import com.javibobadilla.Portfolio.Service.Sh;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/h")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://miportfolio-frontend.web.app")

public class CH {
    @Autowired
    Sh sh;

    @GetMapping("/lista")
    public ResponseEntity<List<h>> list() {
        List<h> list = sh.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<h> getById(@PathVariable("id") int id) {
        if (!sh.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        h h = sh.getOne(id).get();
        return new ResponseEntity(h, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sh.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sh.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoH dtoh) {
        if (StringUtils.isBlank(dtoh.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sh.existsByNombre(dtoh.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        h h = new h(dtoh.getNombre(), dtoh.getPorcentaje());
        sh.save(h);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoH dtoh) {
                if (!sh.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
               if (sh.existsByNombre(dtoh.getNombre()) && sh.getByNombre(dtoh.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
               if (StringUtils.isBlank(dtoh.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        h h = sh.getOne(id).get();
        h.setNombre(dtoh.getNombre());
        h.setPorcentaje(dtoh.getPorcentaje());

        sh.save(h);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}
