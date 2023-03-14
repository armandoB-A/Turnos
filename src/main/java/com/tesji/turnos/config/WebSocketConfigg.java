package com.tesji.turnos.config;

import com.tesji.turnos.repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfigg  implements WebSocketConfigurer {

    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private TableWebSocketHandler tableWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(tableWebSocketHandler, "/tabla-socket").setAllowedOrigins("*");
    }


}