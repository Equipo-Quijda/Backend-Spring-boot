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
        return UsuariosServicio.create(usuario);
    }

    @GetMapping
    public List<Usuarios> getAll() {
        return UsuariosServicio.getAll();
    }

    @GetMapping("/{id}")
    public Usuarios getById(@PathVariable Long id) {
        return UsuariosServicio.getById(id);
    }

    @PutMapping("/{id}")
    public Usuarios update(@PathVariable Long id, @RequestBody Usuarios usuario) {
        return UsuariosServicio.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        UsuariosServicio.delete(id);
    }
}
