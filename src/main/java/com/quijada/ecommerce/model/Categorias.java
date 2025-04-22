package com.quijada.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categorias")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria", unique = true, nullable = false)
    private int id_categoria;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "descripcion",nullable = false)
    private String descripcion;

}
