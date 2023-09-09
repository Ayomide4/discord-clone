package com.backend.discord_clone.emailValidation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;

/**
 * EmailSenderService is the service for the EmailSender class.
 */
@Service
@AllArgsConstructor
public class EmailSenderService implements EmailSender{

    private final JavaMailSender javaMailSender; //JavaMailSender is the interface that is implemented by JavaMailSenderImpl.
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailSenderService.class); //Logger for EmailSenderService.

    /**
     *  Sends email to User.
     */
    @Override
    @Async
    public void send(String to, String email) {
        try{ //Try to send email.
            MimeMessage mimeMessage = javaMailSender.createMimeMessage(); //Creates MimeMessage.
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8"); //Creates MimeMessageHelper.
            mimeMessageHelper.setText(email, true); //Sets text of email.
            mimeMessageHelper.setTo(to); //Sets email to send to.
            mimeMessageHelper.setSubject("Confirm you email"); //Sets subject of email.
            mimeMessageHelper.setFrom("authorize@discordclone.com"); //Sets email to send from.
            javaMailSender.send(mimeMessage); //Sends email.
        } catch (MessagingException e ){  //Catches exception if email fails to send.
            LOGGER.error("Failed to send email", e); //Logs error.
            throw new IllegalStateException("Failed to send Email"); //Throws exception if email fails to send.
        }
    }

    
}
