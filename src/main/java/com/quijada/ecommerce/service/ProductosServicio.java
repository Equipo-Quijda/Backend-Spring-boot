package com.quijada.ecommerce.service;

import com.quijada.ecommerce.model.Productos;
import com.quijada.ecommerce.repository.ProductosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosServicio {
    private final ProductosRepositorio productosRepositorio;

    @Autowired
    public ProductosServicio(ProductosRepositorio productosRepositorio) { this.productosRepositorio = productosRepositorio;}

    public List<Productos> listarProductos () { return productosRepositorio.findAll();}

    // Agregar un nuevo producto
    public Productos agregarProducto(Productos producto){
        return productosRepositorio.save(producto);
    }

    // Obtener productos por nombre
    public Productos listarProductoPorNombre( String nombre){
        return productosRepositorio.findByNombre(nombre).orElseThrow(
                () -> new IllegalArgumentException("El producto " + nombre + " no existe")
        );
    }

    // Metodo para obtener productos por ID
    public Productos listarProductoPorId( int id){
        return productosRepositorio.findById(id).orElseThrow(
                () -> new IllegalArgumentException("El producto con el " + id + " no existe")
        );
    }

    // Borrar producto por nombre
    @Transactional
    public void borrarProductoNombre(String nombre) {
        productosRepositorio.deleteByNombre(nombre);

    }

    // Borrar producto por ID
    public Productos borrarProductosPorId(int id){
        Productos tmp = null;
        if (productosRepositorio.existsById(id)){
            tmp = productosRepositorio.findById(id).get();
            productosRepositorio.deleteById(id);
            return tmp;
        }
        return tmp;
    }

    // Actualizar un producto
    @Transactional
    public Productos actualizarProductoPorId(int id, Productos detallesProducto){
        Optional<Productos> optionalProductos = productosRepositorio.findById(id);
        if (optionalProductos.isEmpty()) throw new IllegalArgumentException("El producto con el " + id + " no existe");
        Productos producto = optionalProductos.get();
        if (detallesProducto.getNombre() != null)producto.setNombre(detallesProducto.getNombre());
        if (detallesProducto.getDescripcion() != null)producto.setDescripcion(detallesProducto.getDescripcion());
        if (detallesProducto.getPrecio() != null)producto.setPrecio(detallesProducto.getPrecio());
        if (detallesProducto.getInventario() != null)producto.setInventario(detallesProducto.getInventario());
        if (detallesProducto.getImagen_url() != null)producto.setImagen_url(detallesProducto.getImagen_url());
//        if (detallesProducto.getId_categoria() != null)producto.setId_categoria(detallesProducto.getId_categoria());
        return productosRepositorio.save(producto);
    }


}





