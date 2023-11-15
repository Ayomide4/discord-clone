package com.backend.discord_clone.Message;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MessageRepository is the repository for the Message class.
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
     Optional<Message> findByMessage(String message); //Finds Message by message

        Optional<Message> findBySender(String sender); //Finds Message by sender

        Optional<Message> findByReceiver(String receiver); //Finds Message by receiver

        Optional<Message> findByTimestamp(String timestamp); //Finds Message by timestamp

        Optional<Message> findByChannel(String channel); //Finds Message by channel
}
