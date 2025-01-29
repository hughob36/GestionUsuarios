package com.gestionUsuarios.gestion.service;

import com.gestionUsuarios.gestion.model.Jefe;
import com.gestionUsuarios.gestion.repository.IJefeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JefeService implements IJefeService {

    @Autowired
    private IJefeRepository jefeRepository;

    @Override
    public String saveJefe(Jefe jefe) {

       jefeRepository.save(jefe);
        return "Creaste nuevo jefe";
    }

    @Override
    public Jefe getJefe(Long id) {
        return jefeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Jefe> getJefe() {
        return jefeRepository.findAll();
    }

    @Override
    public Jefe editJefe(Jefe jefe) {
        Jefe jefeNuevo = jefeRepository.findById(jefe.getId()).orElse(null);

        jefeNuevo.setNombre(jefe.getNombre());
        jefeNuevo.setApellido(jefe.getApellido());
        jefeNuevo.setEdad(jefe.getEdad());

        return jefeRepository.save(jefeNuevo);
    }

    @Override
    public Jefe editJefe(Long idOriginal, Long idNuevo, String nombre, String apellido, int edad) {

        Jefe jefeModificado = jefeRepository.findById(idOriginal).orElse(null);
        /*aca seteo idNuevo si me piden cambiar id*/
        jefeModificado.setNombre(nombre);
        jefeModificado.setApellido(apellido);
        jefeModificado.setEdad(edad);

        jefeRepository.save(jefeModificado);

        return jefeRepository.findById(idNuevo).orElse(null);
    }

    @Override
    public String deleteJefe(long id) {
       jefeRepository.deleteById(id);
        return "Borrado.";
    }
}
