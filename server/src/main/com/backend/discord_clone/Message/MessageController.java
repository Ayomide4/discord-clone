package com.backend.discord_clone.Message;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/message") //Path for the controller.
@CrossOrigin(origins = "http://localhost:5173")
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @MessageMapping("api/v1/message")
    @SendTo("/api/v1/chatRoom")
    public ResponseEntity<String> sendMessage(@RequestBody MessageRequest request) {
        return ResponseEntity.ok(messageService.sendMessage(request));
    }


    //TODO: implement get post request for messages.
    //TODO: Websocket implementation for both server and client.
    //https://spring.io/guides/gs/messaging-stomp-websocket/
    //Learn about websockets and brokers because sometimes they can be complicated
    

    
}
