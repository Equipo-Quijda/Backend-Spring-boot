package com.quijada.ecommerce.controller;


import com.quijada.ecommerce.model.Usuarios;
import com.quijada.ecommerce.service.UsuariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuariosControlador {

    private final UsuariosServicio usuariosServicio;
    @Autowired
    public UsuariosControlador(UsuariosServicio usuariosServicio){
        this.usuariosServicio = usuariosServicio;
    }

    @GetMapping
    public List<Usuarios> getAllUsers(){
        return usuariosServicio.getAllUsers();
    }

    @PostMapping
    public Usuarios addUser(@RequestBody Usuarios usuario){
        return usuariosServicio.addUser(usuario);
    }

}
