package com.sena.clase2.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.sena.clase2.Repositoryes.UsuarioRepositorie;
import com.sena.clase2.dto.UsuarioDto;
import com.sena.clase2.mapper.UsuarioMapper;
import com.sena.clase2.models.Usuario;

public class UsuarioServicesImple implements UsuarioServices {
@Autowired
private UsuarioRepositorie userRepo;
private UsuarioMapper UsuarioMapper;
@Override
public UsuarioDto getUsuario (Integer usuarioid){
    Usuario usuario = userRepo.findById(usuarioid).get();
    return UsuarioMapper.toUsuarioDto(usuario);
}
}

