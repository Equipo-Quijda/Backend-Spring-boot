package com.quijada.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "detalles_pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetallesPedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle", unique = true, nullable = false)
    private Integer id_detalle;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private Double precio_unitario;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "id_producto", nullable = false)
    private Integer id_producto;

    @ManyToOne
    @JoinColumn(name = "pedidos_id_pedidos", nullable = false)
    private Pedidos pedidos;
}
