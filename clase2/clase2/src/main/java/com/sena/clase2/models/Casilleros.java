package com.sena.clase2.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "casilleros")
public class Casilleros {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id_casilleros;
    private String ubicacion;
    private String color;
 
    @OneToOne(targetEntity = LlavesCasilleros.class, cascade =CascadeType.PERSIST)

    @JoinColumn(name = "id_llavescasilleros")
    private LlavesCasilleros llavescasilleros;

    @ManyToOne (targetEntity = Usuario.class, fetch = FetchType.LAZY)
    private Usuario usuario;
}
