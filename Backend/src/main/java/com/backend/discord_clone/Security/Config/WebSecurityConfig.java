package com.backend.discord_clone.Security.Config;

import java.net.http.HttpRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {
    
@Bean
public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
    http
        .authorizeHttpRequests()
        .requestMatchers("/**").hasRole("USER")
        .and()
        .formLogin();
    return http.build();

}

        

}

