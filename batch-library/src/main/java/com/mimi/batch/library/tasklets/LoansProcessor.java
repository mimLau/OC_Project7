package com.mimi.batch.library.tasklets;

import com.mimi.batch.library.mail.EmailService;
import com.mimi.batch.library.mail.Mail;
import com.mimi.batch.library.model.Loan;
import com.mimi.batch.library.proxies.FeignProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class LoansProcessor implements Tasklet {

    private final Logger LOGGER = LogManager.getLogger( LoansProcessor.class );

    @Autowired
    private EmailService emailService;
    private List<Loan> loans;
    private FeignProxy proxy;
    private String token;

    public LoansProcessor( FeignProxy proxy, String token  ) {
        this.proxy = proxy;
        this. token = token;
    }


    @Override
    public RepeatStatus execute( StepContribution contribution, ChunkContext chunkContext ) throws Exception {
        loans = this.proxy.getOutdatedLoanLists(token);

        Map<String, List<Loan>> emailLoan = new HashMap<>();

        for (Loan l : loans) {
            addValue( l.getMember().getAccountOwnerEmail(), l, emailLoan );

        }

        /*for (Map.Entry<String, List<Loan>> entry : emailLoan.entrySet()) {
            LOGGER.error("Id user: " + entry.getKey() );

            for(Loan bor : entry.getValue() ){
                LOGGER.error("Titre: " + bor.getCopy().getPublication().getTitle());
            }
        }*/

            for (Map.Entry<String, List<Loan>> entry : emailLoan.entrySet()) {

                Mail mail = new Mail();
                mail.setFrom("Projet7OCLib@gmail.com");
                mail.setTo( entry.getKey() );
                mail.setSubject("AVIS DE RETARD");

                Map<String, Object> model = new HashMap<>();
                //model.put("name", entry.getKey().getAccountOwnerLastname() + " " + entry.getKey().getAccountOwnerFirstname());
               // model.put("userNb", entry.getKey().getBarcode());
                model.put("loans", entry.getValue());

                mail.setModel(model);
                emailService.sendSimpleMessage(mail);

                //Increment reminder number of a loan each time an email is sending.
                for(Loan l : entry.getValue() )
                    this.proxy.updateReminderNbById( l.getId(), token );

            }

            return RepeatStatus.FINISHED;
        }

    public static void addValue( String key, Loan value, Map<String, List<Loan>> map) {
        List<Loan> list = map.get(key);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(value);
        map.put(key, list);
    }



}
