package com.gestionUsuarios.gestion.controller;


import com.gestionUsuarios.gestion.model.Jefe;
import com.gestionUsuarios.gestion.service.JefeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JefeController {

    @Autowired
    private JefeService jefeService;

    @PostMapping("/jefe/agregar")
    public String saveJefe(@RequestBody Jefe jefe){
        return jefeService.saveJefe(jefe);
    }

    @GetMapping("/jefe/{id}")
    public Jefe getJefe(@PathVariable Long id){
        return jefeService.getJefe(id);
    }

    @GetMapping("/jefe")
    public List<Jefe> getJefe(){
       return  jefeService.getJefe();
    }

    @PutMapping("/jefe/edit/{idOriginal}")
    public Jefe editJefe(@PathVariable Long idOriginal,
                         @RequestParam(required = false, name = "idNuevo") Long idNuevo,
                         @RequestParam(required = false, name = "nombre") String nombre,
                         @RequestParam(required = false, name = "apellido") String apellido,
                         @RequestParam(required = false, name = "edad") int edad){

         return jefeService.editJefe(idOriginal,idNuevo,nombre,apellido,edad);

    }

    @PutMapping("/jefe/edit")
    public Jefe editJefe(@RequestBody Jefe jefe){
        return jefeService.editJefe(jefe);
    }

    @DeleteMapping("/jefe/delete/{id}")
    public String deleteJefe(@PathVariable Long id){
        return jefeService.deleteJefe(id);
    }

}
