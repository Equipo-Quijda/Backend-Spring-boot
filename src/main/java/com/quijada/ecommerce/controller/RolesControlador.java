package com.quijada.ecommerce.controller;

import com.quijada.ecommerce.model.Roles;
import com.quijada.ecommerce.repository.RolesRepositorio;
import com.quijada.ecommerce.service.RolesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/roles/")
public class RolesControlador {
    private final RolesServicio rolesServicio;

    @Autowired
    public RolesControlador(RolesServicio rolesServicio) {
        this.rolesServicio = rolesServicio;
    }

    @GetMapping
    public List<Roles> listarRoles(){ return rolesServicio.listarRoles();}

}
