package com.sena.clase2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.clase2.Repositoryes.UsuarioRepositorie;
import com.sena.clase2.models.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



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
    @GetMapping("/listausuario")
    public  List<Usuario> Usuariolista(){
        return UserRepo. findAll();
    }
@PostMapping("/agregarusuario")
public Usuario Crearusuario(@RequestBody Usuario usuario) {
    return UserRepo.save(usuario);
}

@DeleteMapping("/usuario/{id}")
public String eliminarusuario(@pathVariable Integer id ){
    UserRepo.deleteById(id);
    return "eliminar usu";
}
@PutMapping("usuario/{id}")
public String userupdate(@PathVariable String id, @RequestBody Usuario usuario ) {
    Usuario userupdate = UserRepo.findById(Integer.parseInt(id)).orElse(null);
    if (userupdate == null){
    return "no encontrado";
    }
    userupdate.setNombre(usuario.getNombre());
    userupdate.setApellido(usuario.getApellido());
    userupdate.setCiudad(usuario.getCiudad());
    UserRepo.save (userupdate);
    return "ACTUALIZAO";
}
}