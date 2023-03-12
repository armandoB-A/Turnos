package com.tesji.turnos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "turno", nullable = false, length = 5)
    private String turno;

    @Column(name = "atendido", nullable = false)
    private Boolean atendido = false;

    @Column(name = "fechaRegistro", nullable = false)
    private Instant fechaRegistro;

}