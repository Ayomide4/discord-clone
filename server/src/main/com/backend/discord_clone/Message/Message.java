package com.backend.discord_clone.Message;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
    @SequenceGenerator(     //Generates ID number for Message
        name = "id_sequence", //Name of ID number
        sequenceName = "id_sequence", //Name of sequence
        allocationSize = 1 //How many ID numbers to generate
    )
    @Id 

    @GeneratedValue( //Generates ID number for Message
        strategy =  GenerationType.SEQUENCE, //Strategy for generating ID number
        generator = "id_sequence" //Name of ID number generator
    )
    private Long id; //ID number for Message
    private String message; //Message content.
    @Column(name = "Sender", nullable = false)
    private String sender; //Message sender.
    @Column(name = "Receiver", nullable = false)
    private String receiver; //Message receiver.
    private String timestamp; //Message timestamp.
    @Column(name = "Channel", nullable = false)
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
