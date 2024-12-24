package com.project.Chat.Application.Using.WebSocket.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class ChatController {


    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){
//        chatMessage.setTimestamp(LocalDateTime.now());
        return chatMessage;
    }



    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){

        //add username in websocket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        chatMessage.setTimestamp(LocalDateTime.now());
        return chatMessage;
    }
}
