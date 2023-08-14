package com.backend.discord_clone.Registration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


/**
 * RegistrationController handles user registration.
 */
@RestController
@RequestMapping(value = "/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

private static RegistrationService registrationService;

/** 
 * Register handles the Registration request.
*/
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
}