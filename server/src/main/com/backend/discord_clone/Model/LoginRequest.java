package com.backend.discord_clone.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * LoginRequest class is the class for the Login Request.
 */
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class LoginRequest {
    private final String email; //Username of User
    private final String password; //Password of User
 
    
}

