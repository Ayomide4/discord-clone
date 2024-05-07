package com.backend.discord_clone.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@AllArgsConstructor 
@EqualsAndHashCode
@ToString
@Data
public class MessageRequest {
    private final String message;
    private final String sender;
    private final String receiver;
    private final String timestamp;
    private final String channel;
}
