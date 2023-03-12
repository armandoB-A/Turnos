package com.tesji.turnos.services;

import com.tesji.turnos.entities.Turno;
import com.tesji.turnos.repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;

    public Turno add(Turno turno) {
        return turnoRepository.save(turno);
    }

    public List<Turno> getTurnos() {
        return turnoRepository.findByAtendido(false);
    }
}
