package com.backend.discord_clone.Security.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
public class WebSecurityConfig{
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        //Protects endpoints at /api/<type>/register
        http.authorizeHttpRequests(Configurer ->
                    Configurer
                    .requestMatchers("/api/v*/register/**").permitAll());
        http.formLogin(formLogin -> formLogin
        .loginPage("/login")
        .permitAll());
                    
    return http.build();
    }

   
//overriding depencies



    }


