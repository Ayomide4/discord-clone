package com.backend.discord_clone.Classes.Websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/api/v1/chatRoom");
        registry.setApplicationDestinationPrefixes("/api/v1/message");
        WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
registry.addEndpoint("/api/v1/message").setAllowedOrigins("http://localhost:5173").withSockJS();
        WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
    }
    
    
    


    
}
