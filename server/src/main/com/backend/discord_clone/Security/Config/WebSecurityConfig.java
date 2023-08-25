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

/**
 * Application security configuration file (web based).
 */
@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig{

    @Autowired
    private final AppUserService appUserService;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Chain filter for all security being implemented.
     * @param http Http security name space configuration.
     * @return Returns http build to be implemented.
     * @throws Exception Thrown by the execution of the method or constructor and propagate outside the method or constructor boundary.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable());
        //Protects endpoints at /api/<type>/register
        http.authorizeHttpRequests(Configurer ->
                    Configurer
                    .requestMatchers("/api/v*/registration**").permitAll()
                    .requestMatchers("/index/**").permitAll()
                    .anyRequest().permitAll());
        //building default Login Page.
        http.formLogin((login) ->login.loginPage("/login").permitAll());

        //returns (security) build.
    return http.build();
    }
    

    /**
     * Configures AuthenticationManagerBuilder.
     * @param auth SecurityBuilder used to create an AuthenticationManager. 
     * @throws Exception  Thrown by the execution of the method or constructor and propagate outside the method or constructor boundary.
     */
    @Autowired
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(daoAuthenticationProvider());
    auth.userDetailsService(appUserService);


}

/**
 *  An AuthenticationProvider implementation that retrieves user details
 * @return Returns the built DaoAuthenticationProvider. 
 */
public DaoAuthenticationProvider daoAuthenticationProvider (){
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(bCryptPasswordEncoder);
    provider.setUserDetailsService(appUserService);
    return provider;
}

}

