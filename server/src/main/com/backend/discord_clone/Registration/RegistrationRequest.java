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

    private final String firstName; //First Name of User
    private final String lastName;  //Last Name of User
    private final String email;    //Email of User
    private final String password; //Password of User
    private final String userName; //Username of User


}
