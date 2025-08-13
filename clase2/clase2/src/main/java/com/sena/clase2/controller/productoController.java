package com.sena.clase2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.clase2.Repositoryes.ProductoRepositoryes;
import com.sena.clase2.models.Productos;

@RestController
public class productoController {
    @Autowired
private ProductoRepositoryes productoRepo;

    @GetMapping("/producto")
    public String producto() {
        return new String("conectando desde el controlador producto");
    }
    @GetMapping("/productos")
    public String listarProducto() {
        return productoRepo.findAll().toString();
    }

    @GetMapping("/listaproducto")
    public List<Productos> productolista() {
        return productoRepo.findAll();
    }
}
