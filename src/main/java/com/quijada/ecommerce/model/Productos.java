package com.quijada.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="productos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", unique = true, nullable = false)
    private Integer id_producto;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "precio", nullable = false)
    private Double  precio;
    @Column(name = "inventario", nullable = false)
    private Integer inventario;
    @Column(name = "imagen_url", nullable = false)
    private String imagen_url;
    @Column(name = "id_categoria", nullable = false)
    private Integer id_categoria;

//    @OneToMany()
//    private List<Categorias> id_categoria;




}
