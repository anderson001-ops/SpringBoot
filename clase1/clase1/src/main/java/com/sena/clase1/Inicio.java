package com.sena.clase1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class Inicio {
    @GetMapping("/")
    public String metodo() {
        return new String("hola mundo, mi primer proyecto spring boot");
    }
    
@PostMapping("/hl")
public String metodo1() {
    //TODO: process POST request
    
    return  new String("medio mundo");
    }

@PutMapping("/hll")
public String metodo2() {
    //TODO: process PUT request
    
    return new String("final mundo");
}
@DeleteMapping("/hlll")
    public String metodo3() {
        return new String("eliminar mundo");
    }
@PatchMapping("/hllll")
    public String metodo4() {
        return new String("pusho");
    }
}
