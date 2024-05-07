package com.backend.discord_clone.Controllers;

import com.backend.discord_clone.Model.MessageRequest;
import com.backend.discord_clone.Services.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/message")
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @MessageMapping("api/v1/message")
    @SendTo("/api/v1/chatRoom")
    public ResponseEntity<String> sendMessage(@RequestBody MessageRequest request) {
        return ResponseEntity.ok(messageService.sendMessage(request));
    }

}
