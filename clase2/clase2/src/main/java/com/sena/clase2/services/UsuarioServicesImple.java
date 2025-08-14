package com.sena.clase2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.clase2.Repositoryes.UsuarioRepositorie;
import com.sena.clase2.dto.UsuarioDto;
import com.sena.clase2.mapper.UsuarioMapper;
import com.sena.clase2.models.Usuario;

@Service
public class UsuarioServicesImple implements UsuarioServices {

@Autowired
private UsuarioRepositorie userRepo;

@Autowired
private UsuarioMapper UsuarioMapper;

@Override
public UsuarioDto getUsuario (Integer usuarioid){
    Usuario usuario = userRepo.findById(usuarioid).get();
    return UsuarioMapper.toUsuarioDto(usuario);
}
@Override
public UsuarioDto saveUsuario(UsuarioDto usuarioDto) {
    Usuario usuario = UsuarioMapper.toUsuario(usuarioDto);
    return UsuarioMapper.toUsuarioDto(userRepo.save(usuario));
}
@Override
public List<UsuarioDto> getAllUsuarios() {
    List<Usuario> usuarios = userRepo.findAll();
    return UsuarioMapper.toUsuarioDtoList(usuarios);
}
@Override
public UsuarioDto deleteUsuario(Integer usuarioid) {
    Usuario usuario = userRepo.findById(usuarioid).get();
    userRepo.delete(usuario);
    return UsuarioMapper.toUsuarioDto(usuario);
}
}