package com.sena.clase2.services;

import java.util.List;

import com.sena.clase2.dto.ProductoDto;

public interface ProductoServices {
public ProductoDto getProducto(Integer idproducto);

    public ProductoDto saveProducto(ProductoDto productoDto);
    public List<ProductoDto> getAllProductos();
    public ProductoDto deleteProducto(Integer idproducto);
    public ProductoDto updateProducto(Integer idproducto, ProductoDto productoDto);
}
