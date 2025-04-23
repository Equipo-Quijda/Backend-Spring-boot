package com.quijada.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesPedidosRepositorio extends JpaRepository<DetallesPedidosRepositorio, Integer> {
}
