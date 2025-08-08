package com.sena.clase2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.clase2.Repositoryes.UsuarioRepositorie;

@RestController
public class Usuariocontroller {

    @Autowired
private UsuarioRepositorie UserRepo;

    @GetMapping("/usuario")
    public String usuario(){
        return new String("conectando desde el controlador usuario");
    }

    @GetMapping("/usuarios")
    public String listarUsuario(){
    return UserRepo.findAll().toString();
    }
}
