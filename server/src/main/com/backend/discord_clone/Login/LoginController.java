package com.backend.discord_clone.Login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;


/**
 * RegistrationController handles user registration.
 */
@RestController
@RequestMapping(path = "api/v1/login")
@AllArgsConstructor
public class LoginController {

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok("Login Successful");
    }   
    
    
}
