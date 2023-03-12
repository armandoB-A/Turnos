package com.tesji.turnos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "atencion")
public class Atencion {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "turno", nullable = false, length = 5)
    private String turno;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCaja", nullable = false)
    private Caja idCaja;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;

    @Column(name = "atendido", nullable = false)
    private Integer atendido;

    @Column(name = "fechaAtencion", nullable = false)
    private Instant fechaAtencion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idTurno", nullable = false)
    private Turno idTurno;

}