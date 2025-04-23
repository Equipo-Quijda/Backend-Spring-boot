package com.quijada.ecommerce.controller;

import com.quijada.ecommerce.model.Categorias;
import com.quijada.ecommerce.service.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaControlador {
    private final CategoriaServicio categoriaServicio;

    @Autowired
    public CategoriaControlador(CategoriaServicio categoriaServicio) {
        this.categoriaServicio = categoriaServicio;
    }

    // Listar Categorias
    @GetMapping
    public List<Categorias> listarCategorias(){
        return categoriaServicio.listarCategorias();
    }

    // Agregar una Categoria
    @PostMapping
    public Categorias agregarCategoria(@RequestBody Categorias categoria){
        return categoriaServicio.agregarCategoria(categoria);
    }
}
