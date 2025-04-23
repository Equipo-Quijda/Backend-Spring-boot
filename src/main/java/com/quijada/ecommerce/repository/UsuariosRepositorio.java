package com.quijada.ecommerce.repository;

import com.quijada.ecommerce.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuarios, Integer> {
}
