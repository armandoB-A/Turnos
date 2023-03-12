package com.tesji.turnos.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tesji.turnos.repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;

@Controller
public class TableWebSocketHandler extends TextWebSocketHandler {
/*
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private TurnoRepository turnoRepository;

    public TableWebSocketHandler(TurnoRepository itemRepository) {
        this.turnoRepository = itemRepository;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Si el mensaje recibido es "getTurnos", enviar los turnos al cliente
        List<Turno> items = turnoRepository.findAll();
        String itemsJson = objectMapper.writeValueAsString(items);
        session.sendMessage(new TextMessage(itemsJson));
    }*/
}