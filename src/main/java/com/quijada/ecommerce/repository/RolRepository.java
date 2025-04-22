package com.quijada.ecommerce.repository;

import com.quijada.ecommerce.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer>{

    List<Rol> findByidUsuario(Integer userId);

    Rol findByNameAndUserId(String nombre, Integer idUsuario);
}
