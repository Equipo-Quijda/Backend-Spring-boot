package com.quijada.ecommerce.service;

import com.quijada.ecommerce.model.Categorias;
import com.quijada.ecommerce.model.Productos;
import com.quijada.ecommerce.repository.CategoriasRepository;
import com.quijada.ecommerce.repository.ProductosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicio {
    private final CategoriasRepository categoriasRepository;
    private final ProductosRepositorio productosRepositorio;

    @Autowired
    public CategoriaServicio(CategoriasRepository categoriasRepository, ProductosRepositorio productosRepositorio){
        this.categoriasRepository = categoriasRepository;
        this.productosRepositorio = productosRepositorio;
    }

    // Listar Categorias
    public List<Categorias> listarCategorias(){
        return categoriasRepository.findAll();
    }

    // Agregar una Categoria
    public Categorias agregarCategoria(Categorias categoria) {
        return categoriasRepository.save(categoria);
    }

}
