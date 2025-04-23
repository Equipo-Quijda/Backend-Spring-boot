package com.quijada.ecommerce.repository;

import com.quijada.ecommerce.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepositorio extends JpaRepository<Pedidos, Integer> {
}
