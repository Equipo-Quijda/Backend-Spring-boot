package com.quijada.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedidos", nullable = false, unique = true)
    private Integer id_pedidos;

    @Column(name = "fecha_registro", nullable = false)
    private Timestamp fecha_registro;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "dir_envio", nullable = false)
    private String dir_envio;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Productos> productos;

    @Column(name = "usuario_id", nullable = false)
    private Integer usuario_id;
}
