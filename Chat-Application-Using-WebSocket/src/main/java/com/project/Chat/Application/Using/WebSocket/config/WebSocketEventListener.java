package com.project.Chat.Application.Using.WebSocket.config;

import com.project.Chat.Application.Using.WebSocket.chat.ChatMessage;
import com.project.Chat.Application.Using.WebSocket.chat.MessageType;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Component
public class WebSocketEventListener {

    private static final Logger log = LoggerFactory.getLogger(WebSocketEventListener.class);
    private final SimpMessageSendingOperations messagingTemplate;

    // Constructor for injecting SimpMessageSendingOperations (manual configuration)
    public WebSocketEventListener(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        Map<String, Object> sessionAttributes = headerAccessor.getSessionAttributes();

        if (sessionAttributes != null) {
            String username = (String) sessionAttributes.get("username");
            if (username != null) {
                log.info("User disconnected: {}", username);
                ChatMessage chatMessage = new ChatMessage();
                chatMessage.setType(MessageType.LEAVE);
                chatMessage.setSender(username);
                messagingTemplate.convertAndSend("/topic/public", chatMessage);
            }
        }
    }
}
