package com.backend.discord_clone.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.backend.discord_clone.Interfaces.LoginInterface;
import com.backend.discord_clone.Models.User.CachedLoginResponse;
import com.backend.discord_clone.Models.User.CreateUserRequest;
import com.backend.discord_clone.Models.User.CreateUserResponse;
import com.backend.discord_clone.Models.User.UserLoginCachedRequest;
import com.backend.discord_clone.Models.User.UserLoginResponse;
import com.backend.discord_clone.Models.User.UserLoginRequest;
import com.backend.discord_clone.Services.JWT.JwtService;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/api/v1")
public class LoginController {
    private final LoginInterface loginService;
    @Autowired
    private final JwtService jwtService;

    public LoginController( LoginInterface loginService, JwtService jwtService) {
        this.loginService = loginService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest, HttpServletResponse response) {
        UserLoginResponse userLoginResponse = loginService.login(userLoginRequest);
        if (userLoginResponse.getSuccess() == true){
        String token = jwtService.generateToken(userLoginRequest.getEmail());
        response.addHeader("Authorization", "Bearer " + token);
        }

        return ResponseEntity.ok().body(userLoginResponse);
    }

    @PostMapping("/createUser")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
        return new ResponseEntity<>(loginService.createUser(createUserRequest), HttpStatus.OK);
    }

    @PostMapping("/loginCached")
    public ResponseEntity<CachedLoginResponse> loginCached(@RequestBody UserLoginCachedRequest userLoginCachedRequest) {
        return new ResponseEntity<>(loginService.loginCachedUser(userLoginCachedRequest), HttpStatus.OK);
    }
    

}
