package com.sena.clase2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.clase2.Repositoryes.ProductoRepositorie;
import com.sena.clase2.dto.ProductoDto;
import com.sena.clase2.models.Productos;
import com.sena.clase2.services.ProductoServices;


@RestController
public class productoController {
    @Autowired
private ProductoRepositorie ProductoRepo;

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
    
    @PutMapping("/verproducto/{id}")
    public String productoupdate(@PathVariable String id, @RequestBody Productos producto) {
        Productos productoupdate = ProductoRepo.findById(Integer.parseInt(id)).orElse(null);
        if (productoupdate == null) {
            return "no encontrado";
        }
        productoupdate.setNombreproducto(producto.getNombreproducto());
        productoupdate.setPrecio(producto.getPrecio());
        productoupdate.setCategoria(producto.getCategoria());
        ProductoRepo.save(productoupdate);
        return "actualizaooo";
    }
     // ahora arquictetura de capas producto
@Autowired
private ProductoServices productoService; // Cambia ProductoRepositorie por ProductoService

@GetMapping("productoservi/{id}")
public ResponseEntity<ProductoDto> getProducto(@PathVariable Integer id) {
    return new ResponseEntity<>(productoService.getProducto(id), HttpStatus.OK);
}
//crear producto
@PostMapping("/productoo")
public ResponseEntity<ProductoDto> 
saveProducto(@RequestBody ProductoDto productoDto) {
return new ResponseEntity<>(productoService.saveProducto(productoDto),
HttpStatus.CREATED);
}
//lista productos como el DTO
@GetMapping("/listaprodto")
public ResponseEntity<List<ProductoDto>> getAllProductos() {
return new ResponseEntity<>(productoService.getAllProductos(), HttpStatus.OK);
}

@DeleteMapping("/eliminarpro/{id}")
public ResponseEntity<ProductoDto> deleteProducto(@PathVariable Integer id) {
    return new ResponseEntity<>(productoService.deleteProducto(id), HttpStatus.OK);
}
// actualizar producto
@PutMapping("/productoxd/{id}")
public ResponseEntity<ProductoDto> updateProducto(@PathVariable Integer id,
@RequestBody ProductoDto productoDto) {
    return new ResponseEntity<>(productoService.updateProducto(id, productoDto), HttpStatus.OK);
}
}
