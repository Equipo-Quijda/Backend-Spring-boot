package com.quijada.ecommerce.repository;

import com.quijada.ecommerce.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categorias,Integer> {
}
