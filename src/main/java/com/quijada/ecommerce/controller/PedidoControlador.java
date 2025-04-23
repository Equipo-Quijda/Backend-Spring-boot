package com.quijada.ecommerce.controller;

import com.quijada.ecommerce.model.Pedido;
import com.quijada.ecommerce.service.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoControlador {

    private final PedidoServicio pedidoServicio;
    @Autowired
    public PedidoControlador(PedidoServicio pedidoServicio){this.pedidoServicio = pedidoServicio;}

    //Listar pedidos
    @GetMapping
    public List<Pedido> listarPedidos(){
        return pedidoServicio.listarPedidos();
    }

    //Agregar pedido
    @PostMapping
    public Pedido agregarPedido(@RequestBody Pedido pedido){
        return pedidoServicio.agregarPedido(pedido);
    }

    //editar Pedido
    @PutMapping(path = "/{id}")
    public ResponseEntity<String> editarPedido(@PathVariable("id") int id, @RequestBody Pedido pedido){
        pedidoServicio.editarPedido(id, pedido);
        return ResponseEntity.ok("Producto con ID " + id + " actualizado correctamente");
    }

}
