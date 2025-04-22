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
@RequestMapping("/roles")
public class RolControlador {

    private final RolServicio rolServicio;

    @Autowired
    public RolControlador(RolServicio rolServicio) {
        this.rolServicio = rolServicio;
    }

    @GetMapping
    public ResponseEntity<List<Rol>> getAllRoles() {
        List<Rol> roles = rolServicio.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Integer id) {
        Optional<Rol> rol = rolServicio.getRolById(id);
        return rol.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/usuarios/{idUsuario}")
    public ResponseEntity<List<Rol>> getRolesByUserId(@PathVariable Integer userId) {
        List<Rol> roles = rolServicio.getRolesByUserId(userId);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        Rol savedRol = rolServicio.saveRol(rol);
        return new ResponseEntity<>(savedRol, HttpStatus.CREATED);
    }

    @PostMapping("/user/{idUsuario}")
    public ResponseEntity<Rol> assignRolToUser(@PathVariable Integer userId, @RequestBody Rol rol) {
        try {
            Rol assignedRol = rolServicio.assignRolToUser(userId, rol);
            return new ResponseEntity<>(assignedRol, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{idRol}")
    public ResponseEntity<Rol> updateRol(@PathVariable Integer id, @RequestBody Rol rol) {
        Optional<Rol> existingRol = rolServicio.getRolById(id);
        if (existingRol.isPresent()) {
            rol.setIdRol(id);
            Rol updatedRol = rolServicio.saveRol(rol);
            return new ResponseEntity<>(updatedRol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idRol}")
    public ResponseEntity<HttpStatus> deleteRol(@PathVariable Integer id) {
        try {
            rolServicio.deleteRol(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}