package com.backend.discord_clone.Security.Config;


import com.backend.discord_clone.Services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
 

import com.backend.discord_clone.Security.Cookies.Authentication.AuthEntryPointJwt;
import com.backend.discord_clone.Security.Cookies.Authentication.AuthTokenFilter;

import lombok.AllArgsConstructor;

/**
 * WebSecurityConfig handles web security configuration.
 */
@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig{

    @Autowired
    private final AppUserService appUserService; //App user service.

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;  //Password encoder.

    @Autowired
    private final AuthEntryPointJwt unathorizedHandler; //Unauthorized handler.

    /**
     * Chain filter for all security being implemented.
     * @param http Http security name space configuration.
     * @return Returns http build to be implemented.
     * @throws Exception Thrown by the execution of the method or constructor and propagate outside the method or constructor boundary.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable()) //Disables csrf.
        .exceptionHandling((exceptionHandling) -> exceptionHandling.authenticationEntryPoint(unathorizedHandler)) //Handles unauthorized requests.
        .sessionManagement((sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //Session creation policy.

        //Authorize requests.
        http.authorizeHttpRequests(Configurer ->
                    Configurer //Configures requests.
                    .requestMatchers("/api/v*/registration**").permitAll() //Permits all requests to registration.
                    .requestMatchers("/index/**").permitAll() //Permits all requests to index.
                    .requestMatchers("/api/v*/login").permitAll() //Permits all requests to login.
                    .requestMatchers("/api/v*/message").permitAll() //Permits all requests to message.
                    .anyRequest().permitAll()); //Any other request must be authenticated.
        http.cors(cors -> cors.disable()); //Disables cors.
        
        http.authenticationProvider(daoAuthenticationProvider()); //Authentication provider.

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class); //Adds authentication filter before username and password authentication filter.
            return http.build(); //Returns http build.
    }
    
    /**
     * Creates authentication token filter.
     * @return Returns authentication token filter.
     */
    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter(); //Returns authentication token filter.
    }

    /**
     * Configures AuthenticationManagerBuilder.
     * @param auth SecurityBuilder used to create an AuthenticationManager. 
     * @throws Exception  Thrown by the execution of the method or constructor and propagate outside the method or constructor boundary.
     */
    @Autowired
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(daoAuthenticationProvider()); //Authentication provider.
    auth.userDetailsService(appUserService); //User details service.
    }

    /**
     * Authentication manager.
     * @param auth Authentication configuration.
     * @return Returns authentication manager.
     * @throws Exception Thrown by the execution of the method or constructor and propagate outside the method or constructor boundary.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager(); //Returns authentication manager.
    }

    /**
     *  An AuthenticationProvider implementation that retrieves user details
     * @return Returns the built DaoAuthenticationProvider. 
     */
    public DaoAuthenticationProvider daoAuthenticationProvider (){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(); //Creates DaoAuthenticationProvider.
        provider.setPasswordEncoder(bCryptPasswordEncoder); //Password encoder.
        provider.setUserDetailsService(appUserService); //User details service.
        return provider; //Returns provider.
    }

}

