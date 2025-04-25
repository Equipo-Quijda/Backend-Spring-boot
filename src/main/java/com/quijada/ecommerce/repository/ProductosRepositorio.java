package com.quijada.ecommerce.repository;

import com.quijada.ecommerce.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductosRepositorio extends JpaRepository<Productos, Integer> {
    Optional<Productos> findByNombre(String nombre);
    public void deleteByNombre(String nombre);

}
