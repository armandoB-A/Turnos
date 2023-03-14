package com.tesji.turnos.controllers;

import com.tesji.turnos.entities.Atencion;
import com.tesji.turnos.entities.dto.AtencionDto;
import com.tesji.turnos.services.AtencionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("atencion")
@CrossOrigin
public class AtencioController {
    @Autowired
    private AtencionServices atencionServices;

    @PostMapping
    private ResponseEntity<Atencion> postAtencion(@RequestBody AtencionDto atencionDto){
        return new ResponseEntity<>(atencionServices.addatencion(atencionDto), HttpStatus.OK);
    }
}
