package com.quijada.ecommerce.service;


import com.quijada.ecommerce.model.Usuarios;
import com.quijada.ecommerce.repository.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServicio {

    private UsuariosRepositorio usuariosRepositorio;

    @Autowired
    public UsuariosServicio(UsuariosRepositorio usuariosRepositorio){
        this.usuariosRepositorio = usuariosRepositorio;
    }

    public Usuarios create(Usuarios usuario) {
        return usuariosRepositorio.save(usuario); 
    }

    public List<Usuarios> getAll() {
        return usuariosRepositorio.findAll();
    }

    public Usuarios getById(Integer id) {
        return usuariosRepositorio.findById(id).orElse(null);
    }

    public Usuarios update(Integer id, Usuarios usuario) {
        Usuarios usuarioExistente = usuariosRepositorio.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuario.setIdUsuarios(id);
            return usuariosRepositorio.save(usuario);
        }
        return null;
    }

    public void delete(Integer id) {
        usuariosRepositorio.deleteById(id);
    }
}