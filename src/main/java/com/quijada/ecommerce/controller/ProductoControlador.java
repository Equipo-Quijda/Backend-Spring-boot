package com.quijada.ecommerce.controller;

import com.quijada.ecommerce.model.Productos;
import com.quijada.ecommerce.repository.ProductosRepositorio;
import com.quijada.ecommerce.service.ProductosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping(path = "/api/productos")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductoControlador {
    private final ProductosServicio productosServicio;
    @Autowired
    public ProductoControlador(ProductosServicio productosServicio) { this.productosServicio = productosServicio;}

    @GetMapping
    public ResponseEntity<List<Productos>> listarProductos() { return ResponseEntity.ok(productosServicio.listarProductos());}

    // Agregar producto
    @PostMapping
    public ResponseEntity<Productos> agregarProducto(@RequestBody Productos producto) { return ResponseEntity.status(HttpStatus.CREATED).body(productosServicio.agregarProducto(producto));}

    // Obtener producto por nombre
    @GetMapping(path = "/nombre/{productoNombre}")
    public ResponseEntity<Productos> listarProductoPorNombre(@PathVariable String productoNombre) { return ResponseEntity.ok(productosServicio.listarProductoPorNombre(productoNombre));}

    // Obtener producto por id
    @GetMapping(path = "/id/{productId}")
    public ResponseEntity<Productos> listarProductoPorId(@PathVariable int productId) { return ResponseEntity.ok(productosServicio.listarProductoPorId(productId));}

    // Borrar producto por nombre
    @DeleteMapping(path = "/nombre/{nombre}")
    public ResponseEntity<String> borrarProductoPorNombre(@PathVariable("nombre") String nombre){
        productosServicio.borrarProductoNombre(nombre);
        return ResponseEntity.ok("El producto " + nombre + " ha sido borrado");
    }

    // Borrar producto por ID
    @DeleteMapping(path = "/id/{productId}")
    public ResponseEntity<Productos> borrarProductosPorId(
            @PathVariable int productId) {
        return ResponseEntity.ok(productosServicio.borrarProductosPorId(productId));
    }

    // Actualizar un producto
    @PutMapping(path = "/id/{productId}")
    public ResponseEntity<String> actualizarProductoPorId(
            @PathVariable("productId")int id,
            @RequestBody Productos producto) {
        productosServicio.actualizarProductoPorId(id,producto);
        return ResponseEntity.ok("Producto con ID " + id + " actualizado correctamente");
    }

}
