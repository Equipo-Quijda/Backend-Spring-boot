package com.quijada.ecommerce.service;

import com.quijada.ecommerce.model.Categorias;
import com.quijada.ecommerce.model.Productos;
import com.quijada.ecommerce.model.Roles;
import com.quijada.ecommerce.repository.CategoriasRepositorio;
import com.quijada.ecommerce.repository.RolesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasServicio {
    private final CategoriasRepositorio categoriasRepositorio;

    @Autowired
    public CategoriasServicio(CategoriasRepositorio categoriasRepositorio) {
        this.categoriasRepositorio = categoriasRepositorio;
    }

    public List<Categorias> listarCategorias () { return categoriasRepositorio.findAll();}


    // Agregar un nuevo categoria
    public Categorias agregarCategoria(Categorias categoria){
        return categoriasRepositorio.save(categoria);
    }

    // Metodo para obtener categoriass por ID
    public Categorias listarCategoriasPorId( int id){
        return categoriasRepositorio.findById(id).orElseThrow(
                () -> new IllegalArgumentException("La categoria con el " + id + " no existe")
        );
    }

    // Borrar categoria por ID
    public Categorias borrarCategoriasPorId(int id){
        Categorias tmp = null;
        if (categoriasRepositorio.existsById(id)){
            tmp = categoriasRepositorio.findById(id).get();
            categoriasRepositorio.deleteById(id);
            return tmp;
        }
        return tmp;
    }

    // Actualizar un categoria
    @Transactional
    public Categorias actualizarCategoriasPorId(int id, Categorias detallesProducto){
        Optional<Categorias> optionalCategorias = categoriasRepositorio.findById(id);
        if (optionalCategorias.isEmpty()) throw new IllegalArgumentException("La con el " + id + " no existe");
        Categorias categoria = optionalCategorias.get();
        if (detallesProducto.getNombre() != null)categoria.setNombre(detallesProducto.getNombre());
//        if (detallesProducto.getId_categoria() != null)producto.setId_categoria(detallesProducto.getId_categoria());
        return categoriasRepositorio.save(categoria);
    }

}
