package com.quijada.ecommerce.service;

import com.quijada.ecommerce.model.Pedido;
import com.quijada.ecommerce.repository.PedidoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio {
    private final PedidoRepositorio pedidoRepositorio;

    public  PedidoServicio(PedidoRepositorio pedidoRepositorio){
        this.pedidoRepositorio = pedidoRepositorio;
    }

    //Listar pedidos
    public List<Pedido> listarPedidos(){
        return pedidoRepositorio.findAll();
    }

    //Agregar un pedido
    public Pedido agregarPedido(Pedido pedido){
        return pedidoRepositorio.save(pedido);
    }

    //Editar pedido
    public Pedido editarPedido(int id, Pedido pedidoEditado){
        Optional<Pedido> optionalPedido = pedidoRepositorio.findById(id);
        if (optionalPedido.isEmpty()) throw new IllegalArgumentException("El producto con el id " + id + " no existe.");

        Pedido pedido = optionalPedido.get();

        if (pedidoEditado.getFecha_registro() != null) pedido.setFecha_registro(pedidoEditado.getFecha_registro());
        if (pedidoEditado.getTotal() != null) pedido.setTotal(pedidoEditado.getTotal());
        if (pedidoEditado.getDir_envio() != null) pedido.setDir_envio(pedidoEditado.getDir_envio());
        if (pedidoEditado.getEstado() != null) pedido.setEstado(pedidoEditado.getEstado());
        if (pedidoEditado.getCantidad() != null) pedido.setCantidad(pedidoEditado.getCantidad());
        if (pedidoEditado.getProductos() != null) pedido.setProductos(pedidoEditado.getProductos());
        return pedidoRepositorio.save(pedido);
    }

    //Buscar pedido
    public Pedido buscarPdidoId(int id){
        return pedidoRepositorio.findById(id).orElseThrow(
                () -> new IllegalArgumentException("El pedido con el id " + id + " no existe")
        );
    }
}
