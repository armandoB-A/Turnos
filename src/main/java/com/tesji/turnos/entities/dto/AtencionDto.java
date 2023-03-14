package com.tesji.turnos.entities.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.tesji.turnos.entities.Atencion} entity
 */
@Data
public class AtencionDto implements Serializable {
    private Integer idCajaId;
    private Integer idUsuarioId;
    private Integer idTurnoId;
}