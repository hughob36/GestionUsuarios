package com.gestionUsuarios.gestion.repository;

import com.gestionUsuarios.gestion.model.Jefe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJefeRepository extends JpaRepository <Jefe,Long> {
}
