package com.tesji.turnos.entities.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class UsuarioDto implements Serializable {
    private String usuario;
    private String password;
}