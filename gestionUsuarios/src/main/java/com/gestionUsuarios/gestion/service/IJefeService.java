package com.gestionUsuarios.gestion.service;

import com.gestionUsuarios.gestion.model.Jefe;

import java.util.List;

public interface IJefeService {

    public String saveJefe(Jefe jefe);

    public Jefe getJefe(Long id);

    public List<Jefe> getJefe();

    public Jefe editJefe(Jefe jefe);

    public Jefe editJefe(Long idOriginal, Long idNuevo, String nombre, String apellido, int edad);

    public String deleteJefe(long id);
}
