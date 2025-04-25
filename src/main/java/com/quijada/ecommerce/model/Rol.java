package com.quijada.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol", unique = true, nullable = false)
    private Integer idRol;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

}
