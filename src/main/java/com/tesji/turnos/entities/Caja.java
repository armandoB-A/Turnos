package com.tesji.turnos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "cajas")
public class Caja {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 10)
    private String nombre;

    @Column(name = "fecha_de_registro", nullable = false)
    private Instant fechaDeRegistro;

}