package com.mimi.batch.library.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {


    private JavaMailSender sender;

    public MailUtil(JavaMailSender sender) {
        this.sender = sender;
    }

    public String sendEmail(String to, String TextBody) {
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
            msg = e.getMessage();
        }
        return msg;
    }
}
