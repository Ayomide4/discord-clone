package com.backend.discord_clone.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * PasswordEncoder is the class for password encoding.
 */
@Configuration
public class PasswordEncoder{
    
    /**
     * Creates a instance of BCryptPasswordEncoder.
     * @return Returns new instance of BCryptPasswordEncoder.
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder (){
        return new BCryptPasswordEncoder(); //Returns new instance of BCryptPasswordEncoder.
    }
        
}
