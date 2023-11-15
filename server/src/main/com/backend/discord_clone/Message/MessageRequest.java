package com.backend.discord_clone.Message;

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
    private final String message; //Message content.
    private final String sender; //Message sender.
    private final String receiver; //Message receiver.
    private final String timestamp; //Message timestamp.
    private final String channel; //Message channel.
}
