package com.gestionUsuarios.gestion.service;

import com.gestionUsuarios.gestion.model.Usuario;

import java.util.Date;
import java.util.List;

public interface IUsuarioService {

    public Usuario getUsuario(Long idUsuario);

    public List<Usuario> getUsuario();

    public String saveUsuario(Usuario usuario);

    public Usuario editUsuario(Long idOriginal,Long id,String nombre,String apellido,String membresia,Date fechaNacimiento,Double precio);

    public Usuario editUsuario(Usuario usuario);

    public String deleteUsuario(Long id);
}
