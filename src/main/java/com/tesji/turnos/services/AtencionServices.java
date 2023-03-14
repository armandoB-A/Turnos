package com.tesji.turnos.services;

import com.tesji.turnos.entities.Atencion;
import com.tesji.turnos.entities.dto.AtencionDto;
import com.tesji.turnos.repositories.AtencionRepository;
import com.tesji.turnos.repositories.CajaRepository;
import com.tesji.turnos.repositories.TurnoRepository;
import com.tesji.turnos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AtencionServices {
    @Autowired
    private AtencionRepository atencionRepository;
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private CajaRepository cajaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Atencion addatencion(AtencionDto atencionDto){
        Atencion atencion = new Atencion();
        atencion.setAtendido(1);
        atencion.setFechaAtencion(Instant.now());
        atencion.setIdCaja(cajaRepository.findById(atencionDto.getIdCajaId()).get());
        atencion.setIdTurno(turnoRepository.findById(atencionDto.getIdTurnoId()).get());
        atencion.setIdUsuario(usuarioRepository.findById(atencionDto.getIdUsuarioId()).get());
        return atencionRepository.save(atencion);
    }
}
