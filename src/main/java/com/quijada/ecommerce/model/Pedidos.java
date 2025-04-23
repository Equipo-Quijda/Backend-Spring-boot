package com.quijada.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedidos", unique = true, nullable = false)
    private Integer id_pedidos;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "dir_envio", nullable = false)
    private String dir_envio;
    @Column(name = "total", nullable = false)
    private Double  total;
    @Column(name = "fecha_registro")
    private Date fecha_registro;
    @Column(name = "estado")
    private Integer estado;

    @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallesPedidos> detallesPedidos;
}
