package com.quijada.ecommerce.service;

import com.quijada.ecommerce.repository.CategoriasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriasServicio {
    private final CategoriasRepositorio categoriasRepositorio;

    @Autowired
    public CategoriasServicio(CategoriasRepositorio categoriasRepositorio) {
        this.categoriasRepositorio = categoriasRepositorio;
    }
}
