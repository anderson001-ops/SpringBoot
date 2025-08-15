package com.sena.clase2.services;

import java.util.List;

import com.sena.clase2.dto.UsuarioDto;

public interface UsuarioServices {
    public UsuarioDto getUsuario(Integer usuarioid);

    public UsuarioDto saveUsuario(UsuarioDto usuarioDto);
 
    public List<UsuarioDto> getAllUsuarios();

    public UsuarioDto deleteUsuario(Integer usuarioid);
    public UsuarioDto updateUsuario(Integer usuarioid, UsuarioDto usuarioDto);

}
