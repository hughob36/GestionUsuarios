package com.gestionUsuarios.gestion.repository;

import com.gestionUsuarios.gestion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository <Usuario,Long> {
}
