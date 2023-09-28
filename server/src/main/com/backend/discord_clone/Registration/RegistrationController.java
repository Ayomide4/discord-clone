package com.backend.discord_clone.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


/**
 * RegistrationController handles user registration.
 */
@RestController
@RequestMapping(path = "api/v1/registration") //Path for the controller.
@CrossOrigin(origins = "http://localhost:5173")
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    private final RegistrationService registrationService;

    /**
     * Register is the register Request for a new User. 
     * @param request The request body Information. 
     * @return return Post Request confirmation.
     */
    @PostMapping //Post Request.
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
        return ResponseEntity.ok(registrationService.register(request)); //Returns registrationService.register.
    }

    /**
     * Confirm is the confirm Request for a new User.
     * @param token The token to confirm.
     * @return return Get Request confirmation.
     */
    @GetMapping(path="confirm") //Get Request. 
    public String confirm (@RequestParam("token") String token){
        return registrationService.confirmToken(token); //Returns registrationService.confirmToken.
    }
}
