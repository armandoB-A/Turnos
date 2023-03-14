package com.tesji.turnos.controllers;

import com.tesji.turnos.entities.Usuario;
import com.tesji.turnos.entities.dto.UsuarioDto;
import com.tesji.turnos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
@CrossOrigin
public class UsuariosController {
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping
    public ResponseEntity<Usuario> find(@RequestBody UsuarioDto usuarioDto){
        return new ResponseEntity<>(usuarioService.find(usuarioDto), HttpStatus.OK);
    }
}
