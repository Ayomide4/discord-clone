package com.backend.discord_clone.Registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


 @Getter
 @Setter
 @AllArgsConstructor
 @EqualsAndHashCode
 @ToString
 /**
  * Information being inserted apon Post Request. 
  */
  @Data
public class RegistrationRequest {

    private final String firstName; 
    private final String lastName; 
    private final String email;
    private final String password;
    private final String userName;


}
