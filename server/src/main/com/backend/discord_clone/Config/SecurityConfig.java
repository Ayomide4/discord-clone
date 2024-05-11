package com.backend.discord_clone.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(Configurer -> Configurer
                        .requestMatchers("/api/v1/**").permitAll()
                        .anyRequest().permitAll());

        http.cors(cors -> cors
        .disable());

        http.csrf(csrf -> csrf
        .disable());
        
        return http.build();
    }
}
