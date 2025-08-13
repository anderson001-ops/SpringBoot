package com.sena.clase2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sena.clase2.Repositoryes.ProductoRepositoryes;
import com.sena.clase2.models.Productos;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class productoController {
    @Autowired
private ProductoRepositoryes ProductoRepo;

    @GetMapping("/producto")
    public String producto() {
        return new String("conectando desde el controlador producto");
    }
    @GetMapping("/productos")
    public String listarProducto() {
        return ProductoRepo.findAll().toString();
    }

    @GetMapping("/listaproducto")
    public List<Productos> productolista() {
        return ProductoRepo.findAll();
    }

    @PostMapping("/agregarproducto")
    public Productos crearproducto(@RequestBody Productos producto) {
        return ProductoRepo.save(producto);
    }
    @DeleteMapping("/eliminarproducto/{id}")
    public String eliminarproducto(@PathVariable Integer id) {
        ProductoRepo.deleteById(id);
        return "se elimino producto";
    }
    
}
