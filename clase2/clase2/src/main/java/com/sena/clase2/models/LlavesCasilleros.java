package com.sena.clase2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "llavescasilleros")
public class LlavesCasilleros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_llavescasilleros;
    private Integer numcasillero;
}
