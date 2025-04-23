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

    public Usuarios getUserByName(String nombre){
        return usuariosRepositorio.findByNombre(nombre).orElseThrow(
                () -> new IllegalArgumentException("El usuario con el nombre " + nombre + " no se encuentra")
        );
    }

    public Usuarios getUserByEmail(String correo){
        return usuariosRepositorio.findByCorreo(correo).orElseThrow(
                () -> new IllegalArgumentException("El usuario con el correo " + correo + " no se encuentra")
        );
    }

    public Usuarios deleteUserbyCorreo(String correo){
        Optional<Usuarios> optionalUsuarios = usuariosRepositorio.findByCorreo(correo);
        if (optionalUsuarios.isEmpty()) throw new IllegalArgumentException("El usuario con el correo " + correo + " no se encuentra");
        usuariosRepositorio.deleteByCorreo(correo);
        return optionalUsuarios.get();
    }

    public Usuarios updateUserByCorreo(String correo, Usuarios usuarioDetalles){
        Optional<Usuarios> optionalUsuarios = usuariosRepositorio.findByCorreo(correo);
        if (optionalUsuarios.isEmpty()) throw new IllegalArgumentException("El usuario con el correo " + correo + " no se encuentra");
        Usuarios usuario = optionalUsuarios.get();

        if (usuarioDetalles.getNombre() != null)usuario.setNombre(usuarioDetalles.getNombre());
        if (usuarioDetalles.getApellido() != null)usuario.setApellido(usuarioDetalles.getApellido());
        if (usuarioDetalles.getCorreo() != null)usuario.setCorreo(usuarioDetalles.getCorreo());
        if (usuarioDetalles.getPassword() != null){
            String hashedPassword = passwordEncoder.encode(usuarioDetalles.getPassword());
            usuario.setPassword(hashedPassword);
        }
        return usuariosRepositorio.save(usuario);
    }

    public boolean loginUser(Usuarios usuario){
        Optional<Usuarios>optionalUsuarios = usuariosRepositorio.findByCorreo(usuario.getCorreo());
        if (optionalUsuarios.isEmpty()) return false;
        return passwordEncoder.matches(usuario.getPassword(), optionalUsuarios.get().getPassword());
    }
}