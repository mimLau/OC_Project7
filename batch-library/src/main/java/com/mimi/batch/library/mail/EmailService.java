package com.mimi.batch.library.mail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {

    private final Logger LOGGER = LogManager.getLogger( EmailService.class );


    private JavaMailSender emailSender;
    private SpringTemplateEngine templateEngine;

    public EmailService( JavaMailSender emailSender, SpringTemplateEngine templateEngine ) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    public void sendSimpleMessage( Mail mail ) throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper( message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name()
                );

        helper.addAttachment("logo.png", new ClassPathResource("/static/img/BMS.png"));

        Context context = new Context();
        context.setVariables( mail.getModel() );
        String html = templateEngine.process("emailTemplate", context);

        try {
            helper.setTo( mail.getTo() );
            helper.setText( html, true );
            helper.setSubject( mail.getSubject() );
            helper.setFrom( mail.getFrom() );

            emailSender.send(message);

            LOGGER.info("\n" + "mail triggered successfully to : " + mail.getTo());

        } catch (Exception e) {
            LOGGER.error("Error sending email: " + e.getMessage());
        }
    }
}
