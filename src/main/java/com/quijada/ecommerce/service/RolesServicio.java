package com.quijada.ecommerce.service;

import com.quijada.ecommerce.model.Roles;
import com.quijada.ecommerce.repository.RolesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesServicio {
    private final RolesRepositorio rolesRepositorio;

    @Autowired
    public RolesServicio(RolesRepositorio rolesRepositorio) {
        this.rolesRepositorio = rolesRepositorio;
    }

    public List<Roles> listarRoles () { return rolesRepositorio.findAll();}

}
