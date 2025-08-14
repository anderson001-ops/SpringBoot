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

import com.sena.clase2.Repositoryes.UsuarioRepositorie;
import com.sena.clase2.dto.UsuarioDto;
import com.sena.clase2.models.Usuario;
import com.sena.clase2.services.UsuarioServices;
import org.springframework.web.bind.annotation.RequestParam;




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
    public  List<Usuario> usuariolista(){
        return UserRepo. findAll();
    }
@PostMapping("/agregarusuario")
public Usuario crearusuario(@RequestBody Usuario usuario) {
    return UserRepo.save(usuario);
}

@DeleteMapping("/eliminarusuario/{id}")
public String eliminarusuario(@PathVariable Integer id ){
    UserRepo.deleteById(id);
    return "se elimino usuario";
}
@PutMapping("verusuario/{id}")
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
// arquictetura de capas
@Autowired
private UsuarioServices userServ;

@GetMapping("userservi/{id}")
public ResponseEntity <UsuarioDto> getUsuario (@pathVariable Integer id ) {
    return new ResponseEntity<>(userServ.getUsuario(id),HttpStatus.OK);
}
//crear usuario
@PostMapping("/usuarioo")
public ResponseEntity<UsuarioDto> saveUsuario
(@RequestBody UsuarioDto usuarioDto) {
return new ResponseEntity<>(userServ.saveUsuario(usuarioDto),
HttpStatus.CREATED);
}
//lista usuarios como el DTO
@GetMapping("/listausudto")
public ResponseEntity<List<UsuarioDto>> getAllUsuarios() {
    return new ResponseEntity<>(userServ.getAllUsuarios(), HttpStatus.OK);
}
@DeleteMapping("/eliminaruser/{id}")
public ResponseEntity<UsuarioDto> deleteUsuario(@PathVariable Integer id) {
    return new ResponseEntity<>(userServ.deleteUsuario(id), HttpStatus.OK);
}
}