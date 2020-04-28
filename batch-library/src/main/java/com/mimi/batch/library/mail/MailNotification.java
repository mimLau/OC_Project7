package com.mimi.batch.library.mail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailNotification {

    private final Logger LOGGER = LogManager.getLogger( MailNotification.class );
    private JavaMailSender sender;

    public MailNotification( JavaMailSender sender ) {
        this.sender = sender;
    }

    public String sendEmail( String to, String TextBody ) {
        String msg = "";
        SimpleMailMessage message = new SimpleMailMessage();

        try {
            message.setTo(to);
            message.setText(TextBody);
            message.setSubject("AVIS DE RETARD");
            message.setFrom("Projet7OCLib@gmail.com");
            sender.send( message );
            msg = "mail triggered successfully to : " + to;

        } catch (Exception e) {
            LOGGER.error("Error sending email: " + e.getMessage());
        }

        return msg;
    }
}
