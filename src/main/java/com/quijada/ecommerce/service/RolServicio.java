package com.quijada.ecommerce.service;

import com.quijada.ecommerce.model.Rol;
import com.quijada.ecommerce.model.Usuarios;
import com.quijada.ecommerce.repository.RolRepository;
import com.quijada.ecommerce.repository.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServicio {
    private final RolRepository rolRepositorio;
    private final UsuariosRepositorio usuariosRepositorio;

    @Autowired
    public RolServicio(RolRepository rolRepositorio, UsuariosRepositorio usuariosRepositorio) {
        this.rolRepositorio = rolRepositorio;
        this.usuariosRepositorio = usuariosRepositorio;
    }

    // Obtener todos los roles
    public List<Rol> getAllRoles() {
        return rolRepositorio.findAll();
    }

    // Agregar un rol
    public Rol addRol(Rol rol) {

        Usuarios usuario = usuariosRepositorio.findById(rol.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + rol.getIdUsuario()));

        rol.setUsuario(usuario);
        Rol rolGuardado = rolRepositorio.save(rol);

        usuario.getRoles().add(rolGuardado);
        usuariosRepositorio.save(usuario);

        return rolGuardado;
    }

}
