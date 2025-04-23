package com.quijada.ecommerce.repository;

import com.quijada.ecommerce.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepositorio extends JpaRepository<Categorias, Integer> {

}
