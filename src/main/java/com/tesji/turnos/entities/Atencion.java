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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idCaja", nullable = false)
    private Caja idCaja;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;

    @Column(name = "atendido", nullable = false)
    private Integer atendido;

    @Column(name = "fechaAtencion", nullable = false)
    private Instant fechaAtencion;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idTurno", nullable = false)
    private Turno idTurno;

}