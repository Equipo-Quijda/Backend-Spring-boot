package com.quijada.ecommerce.controller;
import com.quijada.ecommerce.model.Rol;
import com.quijada.ecommerce.repository.RolRepository;
import com.quijada.ecommerce.service.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/roles")
@CrossOrigin(origins = "http://localhost:5501")
public class RolControlador {

    private final RolServicio rolServicio;
    private final RolRepository rolRepository;

    @Autowired
    public RolControlador(RolServicio rolServicio, RolRepository rolRepository) {
        this.rolServicio = rolServicio;
        this.rolRepository = rolRepository;
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

    @GetMapping(path = "/{id}")
    public Rol getRolbyId(@PathVariable int id){
        return rolServicio.getAllRoles().contains(rolRepository.findById(id).get()) ? rolRepository.findById(id).get() : null;
    }
}