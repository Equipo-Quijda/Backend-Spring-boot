package com.quijada.ecommerce.service;

import com.quijada.ecommerce.repository.PedidosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidosServicio {
    private final PedidosRepositorio pedidosRepositorio;

    @Autowired
    public PedidosServicio(PedidosRepositorio pedidosRepositorio) {
        this.pedidosRepositorio = pedidosRepositorio;
    }
}
