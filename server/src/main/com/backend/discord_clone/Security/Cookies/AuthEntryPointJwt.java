package com.backend.discord_clone.Security.Cookies;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * AuthEntryPointJwt handles unauthorized requests.
 */
public class AuthEntryPointJwt implements AuthenticationEntryPoint{

    private static Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class); //Logger for logging events.

    
    /**
     * Handles unauthorized requests.
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        logger.error("Unauthorized error: {}", authException.getMessage()); //Logs unauthorized error.
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized"); //Sends unauthorized error.
    }
    
}
