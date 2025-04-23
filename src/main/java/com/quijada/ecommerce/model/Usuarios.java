package com.quijada.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", unique = true, nullable = false)
    private Integer id_usuario;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "correo", nullable = false)
    private String  correo;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "fecha_registro")
    private Date fecha_registro;

    @ManyToOne
    @JoinColumn(name = "roles_idrol", nullable = false)
    private Roles rol;
}
