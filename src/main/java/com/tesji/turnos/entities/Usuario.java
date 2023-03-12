package com.tesji.turnos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCaja", nullable = false)
    private Caja idCaja;

    @Column(name = "fecha_alta", nullable = false)
    private Instant fechaAlta;

    @Column(name = "fecha_actualizacion", nullable = false)
    private Instant fechaActualizacion;

}