package com.sena.clase2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.clase2.Repositoryes.ProductoRepositorie;
import com.sena.clase2.dto.ProductoDto;
import com.sena.clase2.mapper.ProductoMapper;
import com.sena.clase2.models.Productos;

@Service
public class ProductoServicesImple  implements ProductoServices {
@Autowired
private ProductoRepositorie productoRepo;

@Autowired
private ProductoMapper productoMapper;

@Override
public ProductoDto getProducto(Integer productoid) {
    Productos producto = productoRepo.findById(productoid).get();
    return productoMapper.toProductoDto(producto);
}
@Override
public ProductoDto saveProducto(ProductoDto productoDto) {
    Productos producto = productoMapper.toProducto(productoDto);
    return productoMapper.toProductoDto(productoRepo.save(producto));
}
@Override
public List<ProductoDto> getAllProductos() {
    List<Productos> productos = productoRepo.findAll();
    return productoMapper.toProductoDtoList(productos);
}
@Override
public ProductoDto deleteProducto(Integer productoid) {
    Productos producto = productoRepo.findById(productoid).get();
    productoRepo.delete(producto);
    return productoMapper.toProductoDto(producto);
}
@Override
public ProductoDto updateProducto(Integer productoid, ProductoDto productoDto) {
    Productos producto = productoRepo.findById(productoid).get();
    productoMapper.updateProducto(producto, productoDto);
    return productoMapper.toProductoDto(productoRepo.save(producto));
}
}