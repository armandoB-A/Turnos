package com.tesji.turnos.services;

import com.tesji.turnos.entities.Usuario;
import com.tesji.turnos.entities.dto.UsuarioDto;
import com.tesji.turnos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario find(UsuarioDto usuarioDto){
        return usuarioRepository.findByUsuarioAndPassword(usuarioDto.getUsuario(), usuarioDto.getPassword());
    }
}
