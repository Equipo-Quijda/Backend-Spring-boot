package com.quijada.ecommerce.service;

import com.quijada.ecommerce.repository.DetallesPedidosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallesPedidosServicio {
    private final DetallesPedidosRepositorio detallesPedidosRepositorio;

    @Autowired
    public DetallesPedidosServicio(DetallesPedidosRepositorio detallesPedidosRepositorio) {
        this.detallesPedidosRepositorio = detallesPedidosRepositorio;
    }
}
