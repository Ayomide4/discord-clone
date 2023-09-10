package com.backend.discord_clone.Login;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Data
public class LoginResponse {
    private String email; //Username of User
    private String password; //Password of User
    
    public LoginResponse( String email, String password) {
        this.email = email;
        this.password = password;
    }  
}
