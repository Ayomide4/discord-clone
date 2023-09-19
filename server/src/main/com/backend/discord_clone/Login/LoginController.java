package com.backend.discord_clone.Login;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.discord_clone.AppUser.AppUser;
import com.backend.discord_clone.Security.Cookies.JwtUtils;

import lombok.AllArgsConstructor;

/**
 * RegistrationController handles user registration.
 */
@RestController
@RequestMapping(path = "api/v1/login") //Path for the controller.
@CrossOrigin(origins = "http://localhost:5173")
@AllArgsConstructor
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    /**
     * Handles user login.
     * @param request Login request.
     * @return Returns login response.
     */
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest request) { //Handles user login.
        Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())); //Authenticates user login (checks if user exists and password is correct

        SecurityContextHolder.getContext().setAuthentication(authentication); //Sets authentication context.
        AppUser appUser = (AppUser) authentication.getPrincipal(); //Gets user principal.
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(appUser); //Generates JWT cookie.

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).build(); //Returns response.
    }
    
    
}
