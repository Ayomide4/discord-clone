package com.backend.discord_clone.Services;

import com.backend.discord_clone.Model.Message;
import com.backend.discord_clone.Model.MessageRequest;
import com.backend.discord_clone.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public String sendMessage(MessageRequest request) {
        Message message = new Message( //Creates new Message object.
            request.getMessage(), //Sets message content.
            request.getSender(), //Sets message sender.
            request.getReceiver(), //Sets message receiver.
            request.getTimestamp(), //Sets message timestamp.
            request.getChannel() //Sets message channel.
        );

        messageRepository.save(message);
        return "message sent. ";
    }

}
