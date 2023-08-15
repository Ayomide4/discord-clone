package com.backend.discord_clone.Registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * RegistrationRequest is the main class for a User registration Request
 */
 @Getter
 @Setter
 @AllArgsConstructor
 @EqualsAndHashCode
 @ToString
public class RegistrationRequest {

    private final String name; 
    private final String email;
    private final String password;
    private final String userName;


}
