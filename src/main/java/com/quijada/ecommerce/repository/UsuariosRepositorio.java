package com.quijada.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quijada.ecommerce.model.Usuarios;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuarios,Integer> {
    Optional<Usuarios> findByCorreo (String correo);
    Optional<Usuarios> findByNombre (String nombre);

    @Transactional
    void deleteByCorreo(String correo);

}
