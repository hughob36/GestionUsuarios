package com.gestionUsuarios.gestion.controller;

import com.gestionUsuarios.gestion.model.Usuario;
import com.gestionUsuarios.gestion.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuarios/{id}")
    public Usuario getUsuarios(@PathVariable Long id){
        Usuario usuario = usuarioService.getUsuario(id);
        return usuario;
    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuario(){
        List<Usuario> usuarios = usuarioService.getUsuario();
        return usuarios;
    }

    @PostMapping("/usuario/crear")
    public String saveUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/usuario/editar/{idOriginal}")
    public Usuario editUsuario(@PathVariable Long idOriginal,
                               @RequestParam(required = false, name = "id")Long id,
                               @RequestParam(required = false, name = "nombre") String nombre,
                               @RequestParam(required = false, name = "apellido") String apellido,
                               @RequestParam(required = false, name = "membresia") String membresia,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaNacimiento,
                               @RequestParam(required = false, name = "precio") Double precio) {

        Usuario usuario = usuarioService.editUsuario(idOriginal,id,nombre,apellido,membresia,fechaNacimiento,precio);

        return usuario;
    }

    @PutMapping("/usuario/editar")
    public Usuario editUsuario(@RequestBody Usuario usuario ){
               return usuarioService.editUsuario(usuario);
    }

    @DeleteMapping("/usuario/delete/{id}")
    public String deleteUsuario(@PathVariable Long id){
        return usuarioService.deleteUsuario(id);
    }

}
