package com.quijada.ecommerce.controller;


import com.quijada.ecommerce.model.Usuarios;
import com.quijada.ecommerce.service.UsuariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/nombre/{nombre}")
    public Usuarios getUserByName(@PathVariable("nombre") String nombre) {
        return usuariosServicio.getUserByName(nombre);
    }

    @GetMapping(path = "/correo/{correo}")
    public Usuarios getUserByEmail(@PathVariable("correo") String correo) {
        return usuariosServicio.getUserByEmail(correo);
    }

    @DeleteMapping(path = "/{correo}")
    public ResponseEntity<String> deleteUserbyCorreo(@PathVariable("correo") String correo){
        usuariosServicio.deleteUserbyCorreo(correo);
        return ResponseEntity.ok("Se eliminó la cuenta con el correo " + correo);
    }

    @PutMapping(path = "{correo}")
    public ResponseEntity<String> updateUserByCorreo(@PathVariable("correo") String correo, @RequestBody Usuarios usuario){
        usuariosServicio.updateUserByCorreo(correo,usuario);
        return ResponseEntity.ok("Se actualizó correctamente el usuario");
    }

    @PostMapping(path = "{login}")
    public boolean loginUser(@RequestBody Usuarios usuario){
        return usuariosServicio.loginUser(usuario);
    }
}
