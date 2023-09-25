package com.backend.discord_clone.Message;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Message class.
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Message {
    private String message; //Message content.
    private String sender; //Message sender.
    private String receiver; //Message receiver.
    private String timestamp; //Message timestamp.
    private String channel; //Message channel.
    
    /**
     *  Message constructor.
     * @param message Message content.
     * @param sender Message sender.
     * @param receiver Message receiver.
     * @param timestamp Message timestamp.
     * @param channel Message channel.
     */
    public Message(String message, String sender, String receiver, String timestamp, String channel) { //Constructor.
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = timestamp;
        this.channel = channel;
    }
    
}
