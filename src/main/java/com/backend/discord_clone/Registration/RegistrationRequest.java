package com.backend.discord_clone.Registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * RegistrationRequest is the main class for a User registration Request
 */
 @Getter
 @AllArgsConstructor
 @EqualsAndHashCode
 @ToString
public class RegistrationRequest {

    private final String firstName;
    private final String lastName; 
    private final String email;
    private final String password;
    private final String userName;


}
