package com.quijada.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    private Integer id_categoria;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "categorias", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Productos> productos = new ArrayList<>();

}
