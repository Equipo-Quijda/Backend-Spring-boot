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

    public List<Rol> getAllRoles() {
        return rolRepositorio.findAll();
    }

    public Optional<Rol> getRolById(Integer id) {
        return rolRepositorio.findById(id);
    }

    public List<Rol> getRolesByUserId(Integer idUsuario) {
        return rolRepositorio.findByidUsuario(idUsuario);
    }

    public Rol saveRol(Rol rol) {
        return rolRepositorio.save(rol);
    }

    public Rol assignRolToUser(Integer idUsuario, Rol rol) {
        Optional<Usuarios> userOptional = usuariosRepositorio.findById(idUsuario);
        if (userOptional.isPresent()) {
            Usuarios usuario = userOptional.get();
            rol.setUsuario(usuario);
            return rolRepositorio.save(rol);
        }
        throw new RuntimeException("Usuario no encontrado con ID: " + idUsuario);
    }

    public void deleteRol(Integer id) {
        rolRepositorio.deleteById(id);
    }
}
