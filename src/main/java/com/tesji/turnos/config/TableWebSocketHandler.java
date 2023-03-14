package com.tesji.turnos.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tesji.turnos.entities.Caja;
import com.tesji.turnos.entities.Turno;
import com.tesji.turnos.services.CajaService;
import com.tesji.turnos.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
@Controller
public class TableWebSocketHandler extends TextWebSocketHandler {
    private List<WebSocketSession> sesiones = new ArrayList<>();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private CajaService cajaService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sesiones.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String messagess = message.getPayload();
        objectMapper.registerModule(new JavaTimeModule());
        //turnos
        if (messagess.startsWith("guardarTurno")) {
            turnoService.add();
            getturnos();
            int turnosfaltantes = turnoService.getTurnosfaltantes();
            String messageToSend = "sizeTurnosç" + turnosfaltantes;
            sesiones.forEach(webSocketSession -> {
                try {
                    webSocketSession.sendMessage(new TextMessage(messageToSend));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        else if (messagess.equals("getTurnos")) {
            List<Turno> items = turnoService.getTurnos();
            String itemsJson = objectMapper.writeValueAsString(items);
            String messageToSend = "listaTurnosç" + itemsJson; // prefijo + contenido
            session.sendMessage(new TextMessage(messageToSend));
        }

        else if (messagess.equals("getSizeTurnos")) {
            int turnosfaltantes = turnoService.getTurnosfaltantes();
            String messageToSend = "sizeTurnosç" + turnosfaltantes; // prefijo + contenido
            session.sendMessage(new TextMessage(messageToSend));
        }

        else if (messagess.startsWith("offTurno")) {
            String id = messagess.substring(8);
            turnoService.updateFalse(id);
            getturnos();
        }

        else if (messagess.equals("getTurnoDisponible")) {
            Turno turnosDisp = turnoService.getTurnoDisponible();
            String itemsJson = objectMapper.writeValueAsString(turnosDisp);
            String messageToSend = "turnosdispç" + itemsJson; // prefijo + contenido
            session.sendMessage(new TextMessage(messageToSend));
        }
        //cajas
        else if (messagess.startsWith("changeStatusCaja")) {
            String id = messagess.substring(16);
            cajaService.updateStatus(id);
            getCajas();
        }

        else if (messagess.startsWith("getCajas")) {
            getCajas();
        }

        else if (messagess.startsWith("getCajaDisponible")) {
            //cajasss
            Caja cajas = cajaService.getCajaDisponible();
            String itemsJson = objectMapper.writeValueAsString(cajas);
            String messageToSend = "cajadispoç" + itemsJson;
            sesiones.forEach(webSocketSession -> {
                try {
                    webSocketSession.sendMessage(new TextMessage(messageToSend));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

    }

    private void getCajas() throws JsonProcessingException {
        List<Caja> cajas = cajaService.getCajas();
        String itemsJson = objectMapper.writeValueAsString(cajas);
        String messageToSend = "cajasç" + itemsJson; // prefijo + contenido
        sesiones.forEach(webSocketSession -> {
            try {
                webSocketSession.sendMessage(new TextMessage(messageToSend));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void getturnos() throws JsonProcessingException {
        List<Turno> items = turnoService.getTurnos();
        String itemsJson = objectMapper.writeValueAsString(items);
        String messageToSend = "turnoAgregadoç" + itemsJson; // prefijo + contenido
        sesiones.forEach(webSocketSession -> {
            try {
                webSocketSession.sendMessage(new TextMessage(messageToSend));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sesiones.remove(session);
    }
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