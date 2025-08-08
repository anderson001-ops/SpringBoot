package com.sena.clase2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Productos")
public class Productos {
    @Id
    @column( name="id_productos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_productos;
    private String nombreproducto;
    private Integer precio;
    private String categoria;

}
