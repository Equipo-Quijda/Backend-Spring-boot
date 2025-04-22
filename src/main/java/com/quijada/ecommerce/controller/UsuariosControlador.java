package com.quijada.ecommerce.controller;


import com.quijada.ecommerce.model.Usuarios;
import com.quijada.ecommerce.service.UsuariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Usuarios")
public class UsuariosControlador {
    @Autowired
    private UsuariosServicio usuariosServicio;

    @PostMapping
    public Usuarios create(@RequestBody Usuarios usuario) {
        return usuariosServicio.create(usuario);
    }

    @GetMapping
    public List<Usuarios> getAll() {
        return usuariosServicio.getAll();
    }

    @GetMapping("/{id}")
    public Usuarios getById(@PathVariable Integer id) {
        return usuariosServicio.getById(id);
    }

    @PutMapping("/{id}")
    public Usuarios update(@PathVariable Integer id, @RequestBody Usuarios usuario) {
        return usuariosServicio.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        usuariosServicio.delete(id);
    }
}
