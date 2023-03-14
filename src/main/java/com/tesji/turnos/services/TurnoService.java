package com.tesji.turnos.services;

import com.tesji.turnos.entities.Turno;
import com.tesji.turnos.repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;

    public Turno add() {
        Turno turno= new Turno();
        int turnost =Integer.parseInt(turnoRepository.findFirstByOrderByIdDesc().getTurno())+1;
        String fol="";
        if (turnost<10){
            fol+="00"+turnost;
        } else {
            fol+="0"+turnost;
        }
        if (turnost>=100){
            fol+=turnost;
        }
        turno.setTurno(fol);
        turno.setAtendido(false);
        turno.setFechaRegistro(Instant.now());
        return turnoRepository.saveAndFlush(turno);
    }

    public List<Turno> getTurnos() {
        return turnoRepository.findByAtendido(false);
    }
    public int getTurnosfaltantes() {
        return turnoRepository.findByAtendido(false).size();
    }
    public Turno getTurnoDisponible(){
        return turnoRepository.findFirstByAtendidoOrderByIdAsc(false);
    }

    public void updateFalse(String id) {
        Turno t= turnoRepository.findById(Integer.parseInt(id)).get();
        t.setAtendido(true);
        turnoRepository.saveAndFlush(t);
    }
}
