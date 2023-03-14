package com.tesji.turnos.controllers;

import com.tesji.turnos.entities.Turno;
import com.tesji.turnos.repositories.TurnoRepository;
import com.tesji.turnos.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turno")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @PostMapping()
    public ResponseEntity<Turno> addItem() {
        return new ResponseEntity<>(turnoService.add(), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Turno>> getAllTurnos() {
        return new ResponseEntity<>(turnoService.getTurnos(), HttpStatus.OK);
    }
}