package com.alwi.chatapp.chat.controller;

import com.alwi.chatapp.chat.dto.message.MessageRequestDTO;
import com.alwi.chatapp.chat.exception.ValidationException;
import com.alwi.chatapp.chat.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/chat-app/")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @PostMapping("/message")
    public ResponseEntity<Object> sendMessage(@RequestBody MessageRequestDTO requestBody) throws ValidationException {
        String response = String.valueOf(messageService.sendMessage(requestBody));
        return ResponseEntity.ok(response);
    }
}





