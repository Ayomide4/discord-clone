package com.backend.discord_clone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.backend.discord_clone.interfaces.LoginInterface;
import com.backend.discord_clone.models.User.CachedLoginResponse;
import com.backend.discord_clone.models.User.CreateUserRequest;
import com.backend.discord_clone.models.User.CreateUserResponse;
import com.backend.discord_clone.models.User.UserLoginCachedRequest;
import com.backend.discord_clone.models.User.UserLoginReponse;
import com.backend.discord_clone.models.User.UserLoginRequest;
import com.backend.discord_clone.services.login.UserLoginService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/api/v1")
public class LoginController {

    private final LoginInterface loginService;

    public LoginController(@Autowired UserLoginService userLoginService) {
        this.loginService = userLoginService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginReponse> login(@RequestBody UserLoginRequest userLoginRequest) {
        return new ResponseEntity<>(loginService.login(userLoginRequest), HttpStatus.OK);
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
