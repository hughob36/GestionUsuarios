package com.gestionUsuarios.gestion.service;

import com.gestionUsuarios.gestion.model.Usuario;
import com.gestionUsuarios.gestion.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepositorio;

    @Override
    public Usuario getUsuario(Long idUsuario) {
        return usuarioRepositorio.findById(idUsuario).orElse(null);
    }

    @Override
    public List<Usuario> getUsuario() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public String saveUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
        return "Creaste nuevo usuario";
    }

    @Override
    public Usuario editUsuario(Long idOriginal,Long id, String nombre, String apellido, String membresia,
                               Date fechaNacimiento, Double precio) {

        Usuario usuario = usuarioRepositorio.findById(idOriginal).orElse(null);
        usuario.setId(id);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setMembresia(membresia);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setPrecio(precio);

        usuarioRepositorio.save(usuario);

        return usuario;
    }

    @Override
    public Usuario editUsuario(Usuario usuario) {
        Usuario usuarioNuevo = usuarioRepositorio.findById(usuario.getId()).orElse(null);
        usuarioNuevo.setNombre(usuario.getNombre());
        usuarioNuevo.setApellido(usuario.getApellido());
        usuarioNuevo.setMembresia(usuario.getMembresia());
        usuarioNuevo.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioNuevo.setPrecio(usuario.getPrecio());

        usuarioRepositorio.save(usuarioNuevo);

        return usuarioNuevo;
    }

    @Override
    public String deleteUsuario(Long id) {

        usuarioRepositorio.deleteById(id);

        return "Eliminaste un Usuario";
    }
}
