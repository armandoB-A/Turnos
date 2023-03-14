package com.tesji.turnos.services;

import com.tesji.turnos.entities.Caja;
import com.tesji.turnos.repositories.CajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CajaService {
    @Autowired
    private CajaRepository cajaRepository;

    public List<Caja> getCajas(){
        return cajaRepository.findAll();
    }

    public Caja getCajaDisponible(){
        return cajaRepository.findFirstByOcupada(false);
    }

    public void updateStatus(String id) {
        Caja caja= cajaRepository.findById(Integer.parseInt(id)).get();
        caja.setOcupada(!caja.getOcupada());
        cajaRepository.save(caja);
    }
}