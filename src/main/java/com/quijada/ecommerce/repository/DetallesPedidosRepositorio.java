package com.quijada.ecommerce.repository;

import com.quijada.ecommerce.model.DetallesPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesPedidosRepositorio extends JpaRepository<DetallesPedidos, Integer> {
}
