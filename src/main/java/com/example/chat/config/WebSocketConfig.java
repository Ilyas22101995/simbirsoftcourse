package com.example.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;
@Configuration
@EnableWebSocketMessageBroker                                                // Annotation enable WebSocket server
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {     // Default method: Registration of the end point
        registry.addEndpoint("/ws").withSockJS();                   // for connecting clients to the WebSocket
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {    // Default method: Setting up a message broker, sending client messages
        registry.setApplicationDestinationPrefixes("/app");                 // If the address starts with /app, we send it to the message handler (Annotation @MessageMapping)
        registry.enableSimpleBroker("/topic");            // If the address starts with /topic, we send it to the message broker
    }
}
