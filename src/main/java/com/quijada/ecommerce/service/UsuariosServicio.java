package com.quijada.ecommerce.service;


import com.quijada.ecommerce.model.Usuarios;
import com.quijada.ecommerce.repository.RolRepository;
import com.quijada.ecommerce.repository.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServicio {

    private UsuariosRepositorio usuariosRepositorio;
    private final PasswordEncoder passwordEncoder;
    private final RolRepository rolRepository;

    @Autowired
    public UsuariosServicio(UsuariosRepositorio usuariosRepositorio, PasswordEncoder passwordEncoder, RolRepository rolRepository){
        this.usuariosRepositorio = usuariosRepositorio;
        this.passwordEncoder = passwordEncoder;
        this.rolRepository = rolRepository;
    }

    public List<Usuarios> getAllUsers() {
        return usuariosRepositorio.findAll();
    }

    public Usuarios addUser(Usuarios usuario){
        Optional<Usuarios> optionalUsuarios = usuariosRepositorio.findByCorreo(usuario.getCorreo());
        if (optionalUsuarios.isPresent()) throw new IllegalArgumentException("El correo ya existe");
        String hashedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(hashedPassword);
        return usuariosRepositorio.save(usuario);
    }

}