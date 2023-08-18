package com.backend.discord_clone.Security.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.backend.discord_clone.AppUser.AppUserService;

import lombok.AllArgsConstructor;


@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig{

    @Autowired
    private final AppUserService appUserService;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable());
        //Protects endpoints at /api/<type>/register
        http.authorizeHttpRequests(Configurer ->
                    Configurer
                    .requestMatchers("/api/v1/registration").permitAll()
                    .requestMatchers("/index/**").permitAll()
                    .anyRequest().permitAll());
        http.formLogin((login) ->login.loginPage("/login").permitAll());
    return http.build();
    }
    

    @Autowired
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(daoAuthenticationProvider());
    auth.userDetailsService(appUserService);


}

public DaoAuthenticationProvider daoAuthenticationProvider (){
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(bCryptPasswordEncoder);
    provider.setUserDetailsService(appUserService);
    return provider;
}

}

