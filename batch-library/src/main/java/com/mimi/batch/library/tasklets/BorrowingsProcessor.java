package com.mimi.batch.library.tasklets;

import com.mimi.batch.library.mail.EmailService;
import com.mimi.batch.library.mail.Mail;
import com.mimi.batch.library.mail.MailNotification;
import com.mimi.batch.library.model.Borrowing;
import com.mimi.batch.library.model.Member;
import com.mimi.batch.library.model.MemberBorrowing;
import com.mimi.batch.library.proxies.FeignProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.*;

public class BorrowingsProcessor implements Tasklet {

    private final Logger LOGGER = LogManager.getLogger( BorrowingsProcessor.class );

    @Autowired
    private EmailService emailService;
    private List<Borrowing> borrowings;
    private FeignProxy proxy;
    private String token;

    public BorrowingsProcessor( FeignProxy proxy, String token  ) {
        this.proxy = proxy;
        this. token = token;
    }


    @Override
    public RepeatStatus execute( StepContribution contribution, ChunkContext chunkContext ) throws Exception {
        borrowings = this.proxy.getOutdatedBorrowingLists(token);

        Map<String, List<Borrowing>> emailBorrowing = new HashMap<>();

        for (Borrowing b : borrowings) {
            addValue( b.getMember().getAccountOwnerEmail(), b, emailBorrowing );

        }

        /*for (Map.Entry<String, List<Borrowing>> entry : emailBorrowing.entrySet()) {
            LOGGER.error("Id user: " + entry.getKey() );

            for(Borrowing bor : entry.getValue() ){
                LOGGER.error("Titre: " + bor.getCopy().getPublication().getTitle());
            }
        }*/

            for (Map.Entry<String, List<Borrowing>> entry : emailBorrowing.entrySet()) {

                Mail mail = new Mail();
                mail.setFrom("Projet7OCLib@gmail.com");
                mail.setTo( entry.getKey() );
                mail.setSubject("AVIS DE RETARD");

                Map<String, Object> model = new HashMap<>();
                //model.put("name", entry.getKey().getAccountOwnerLastname() + " " + entry.getKey().getAccountOwnerFirstname());
               // model.put("userNb", entry.getKey().getBarcode());
                model.put("borrowings", entry.getValue());

                mail.setModel(model);
                emailService.sendSimpleMessage(mail);

            }

            return RepeatStatus.FINISHED;
        }

    public static void addValue( String key, Borrowing value, Map<String, List<Borrowing>> map) {
        List<Borrowing> list = map.get(key);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(value);
        map.put(key, list);
    }



}
