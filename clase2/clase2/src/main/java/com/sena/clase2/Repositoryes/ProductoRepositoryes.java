package com.sena.clase2.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.clase2.models.Productos;

public interface ProductoRepositoryes extends JpaRepository <Productos, Integer> {

}
