package com.quijada.ecommerce.service;

import com.quijada.ecommerce.model.Roles;
import com.quijada.ecommerce.model.Usuarios;
import com.quijada.ecommerce.repository.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServicio {
    private final UsuariosRepositorio usuariosRepositorio;

    @Autowired
    public UsuariosServicio(UsuariosRepositorio usuariosRepositorio) {
        this.usuariosRepositorio = usuariosRepositorio;
    }

    public List<Usuarios> listarUsuarios () { return usuariosRepositorio.findAll();}
}
