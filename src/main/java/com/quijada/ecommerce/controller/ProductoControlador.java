package com.quijada.ecommerce.controller;

import com.quijada.ecommerce.model.Productos;
import com.quijada.ecommerce.repository.ProductosRepositorio;
import com.quijada.ecommerce.service.ProductosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:5501"})

@RequestMapping(path = "/productos")
public class ProductoControlador {
    private final ProductosServicio productosServicio;
    @Autowired
    public ProductoControlador(ProductosServicio productosServicio) { this.productosServicio = productosServicio;}

    @GetMapping
    public List<Productos> listarProductos(){ return productosServicio.listarProductos();}

    // Agregar producto
    @PostMapping
    public Productos agregarProducto(@RequestBody Productos producto) { return productosServicio.agregarProducto(producto);}

    // Obtener producto por nombre
    @GetMapping(path = "/nombre/{productoNombre}")
    public Productos listarProductoPorId(@PathVariable("productoNombre") String nombre) {return productosServicio.listarProductoPorNombre(nombre);}

    // Obtener producto por id
    @GetMapping(path = "/id/{productId}")
    public Productos listarProductoPorId(@PathVariable("productId")int id){
        return productosServicio.listarProductoPorId(id);
    }

    // Borrar producto por nombre
    @DeleteMapping(path = "/nombre/{nombre}")
    public ResponseEntity<String> borrarProductoPorNombre(@PathVariable("nombre") String nombre){
        productosServicio.borrarProductoNombre(nombre);
        return ResponseEntity.ok("El producto " + nombre + " ha sido borrado");
    }

    // Borrar producto por ID
    @DeleteMapping(path = "/id/{productId}")
    public Productos borrarProductosPorId(@PathVariable("productId") int id){
        return productosServicio.borrarProductosPorId(id);
    }

    // Actualizar un producto
    @PutMapping(path = "/id/{productId}")
    public ResponseEntity<String> actualizarProductoPorId(
            @PathVariable("productId")int id,
            @RequestBody Productos producto)
    {
        productosServicio.actualizarProductoPorId(id,producto);
        return ResponseEntity.ok("Producto con ID " + id + " actualizado correctamente");
    }

}
