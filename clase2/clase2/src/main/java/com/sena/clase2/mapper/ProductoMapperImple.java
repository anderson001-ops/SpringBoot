package com.sena.clase2.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sena.clase2.dto.ProductoDto;
import com.sena.clase2.models.Productos;

@Component
public class ProductoMapperImple implements ProductoMapper {
@Override
public Productos toProducto(ProductoDto productoDto) {
    if (productoDto == null) {
        return null;
    }
    Productos producto = new Productos();
    producto.setId_productos(productoDto.getIdpro());
    producto.setCategoria(productoDto.getCate());
    producto.setNombreproducto(productoDto.getNompro());
    producto.setPrecio(productoDto.getPreci());
    return producto;
}
@Override
public ProductoDto toProductoDto(Productos producto) {
    if (producto == null) {
        return null;
    }
    ProductoDto productoDto = new ProductoDto();
    productoDto.setIdpro(producto.getId_productos());
    productoDto.setCate(producto.getCategoria());
    productoDto.setNompro(producto.getNombreproducto());
    productoDto.setPreci(producto.getPrecio());
    return productoDto;
}
@Override
public List<ProductoDto> toProductoDtoList(List<Productos> productos) {
    if (productos == null) {
        return List.of();
    }
    List<ProductoDto> productoDtos = new ArrayList<ProductoDto>(productos.size());
    for (Productos producto : productos) {
        productoDtos.add(toProductoDto(producto));
    }
    return productoDtos;
}
@Override
public void updateProducto(Productos producto, ProductoDto productoDto) {
    if (productoDto == null) {
        return;
    }
    producto.setCategoria(productoDto.getCate());
    producto.setNombreproducto(productoDto.getNompro());
    producto.setPrecio(productoDto.getPreci());
}
}
