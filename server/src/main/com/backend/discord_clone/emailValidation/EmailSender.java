package com.backend.discord_clone.emailValidation;

/**
 * EmailSender is the interface for the EmailSender class.
 */
public interface EmailSender {
    void send (String to, String email); //Sends email to User.
    }

