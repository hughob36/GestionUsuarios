package com.gestionUsuarios.gestion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private String membresia;
    private Date fechaNacimiento;
    private Double precio;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellido, String membresia, Date fechaNacimiento, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.membresia = membresia;
        this.fechaNacimiento = fechaNacimiento;
        this.precio = precio;
    }
}
