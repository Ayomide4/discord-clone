package com.backend.discord_clone.Security.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.backend.discord_clone.AppUser.AppUserService;

import lombok.AllArgsConstructor;


@Configuration
@AllArgsConstructor
@EnableWebFluxSecurity
public class WebSecurityConfig extends WebSecurityConfiguration{

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
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
    
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(daoAuthenticationProvider());


}

public DaoAuthenticationProvider daoAuthenticationProvider (){
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(bCryptPasswordEncoder);
    provider.setUserDetailsService(appUserService);
    return provider;
}

}

