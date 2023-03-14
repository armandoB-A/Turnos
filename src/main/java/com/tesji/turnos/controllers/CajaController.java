package com.tesji.turnos.controllers;

import com.tesji.turnos.entities.Caja;
import com.tesji.turnos.services.CajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("caja")
@CrossOrigin
public class CajaController {

    @Autowired
    private CajaService cajaService;
    @GetMapping
    public ResponseEntity<List<Caja>> getCajas(){
        return new ResponseEntity<>(cajaService.getCajas(), HttpStatus.OK);
    }
}
