package tn.example.projet.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import tn.example.projet.model.ChatMessage;
import tn.example.projet.service.BadWordsException;
import tn.example.projet.service.BadWordsService;



@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) throws BadWordsException {
    	
    BadWordsService.loadConfigs();	
		//publication.setTitle4(BadWordsPublication.filterText(publication.getTitle()));
        chatMessage.setContent(BadWordsService.filterText(chatMessage.getContent()));

        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) throws BadWordsException {
        chatMessage.setContent(BadWordsService.filterText(chatMessage.getContent()));

    	// Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());

        return chatMessage;
    }

}
