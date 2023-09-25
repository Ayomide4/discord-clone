package com.backend.discord_clone.Message;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/message") //Path for the controller.
@CrossOrigin(origins = "http://localhost:5173")
@AllArgsConstructor
public class MessageController {

    @PostMapping
    public ResponseEntity <String> sendMessage(@RequestBody MessageRequest request) {
        return ResponseEntity.ok("Message sent");
    }


    
}
