package com.quijada.ecommerce.controller;
import com.quijada.ecommerce.model.Rol;
import com.quijada.ecommerce.service.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/roles")
@CrossOrigin(origins = "http://localhost:5501")
public class RolControlador {

    private final RolServicio rolServicio;

    @Autowired
    public RolControlador(RolServicio rolServicio) {
        this.rolServicio = rolServicio;
    }

    // Obtener todos los roles
    @GetMapping
    public List<Rol> getAllRoles(){
        return rolServicio.getAllRoles();
    }

    // Agregar un rol
    @PostMapping
    public Rol addRol(@RequestBody Rol rol){
        return rolServicio.addRol(rol);
    }


}