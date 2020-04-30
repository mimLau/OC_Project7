package com.mimi.batch.library.chuncks;

import com.mimi.batch.library.model.Loan;
import org.springframework.batch.item.ItemProcessor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.mimi.batch.library.mail.MailNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoanItemProcessor implements ItemProcessor<Loan, Loan> {

   @Autowired private MailNotification util;

    @Override
    public Loan process(Loan Loan) throws Exception {

        String msg = util.sendEmail(Loan.getMember().getAccountOwnerEmail(), buildMessage( Loan ));
        System.out.println(msg);
        return Loan;
    }

    private String buildMessage( Loan Loan ) {
        String mailBody = "Bonjour," + "\n"
                + "\n" + "- Date  : " + LocalDate.now()
                + "\n" + "- Nom de l'abonnée  : " + Loan.getMember().getAccountOwnerLastname() + " " + Loan.getMember().getAccountOwnerFirstname()
                + "\n" + "- Numéro de l'abonnée  : " + Loan.getMember().getBarcode()
                + "\n" + "- Titre : " + Loan.getCopy().getPublication().getTitle()
                + "\n" + "- No de document  : " + Loan.getCopy().getPublication().getIdentificationNb()
                + "\n" + "- Échéance  : " + new SimpleDateFormat("dd/MM/yyyy").format(java.sql.Date.valueOf(Loan.getReturnDate()))
                + "\n" + "\n" + "Nous vous remercions de bien vouloir rapporter au plus vite ce(s) document(s) dans l'une des bibliothèques municipales de Strasbourg."

                + "\n" + "\n" + "Ceci est un rappel automatique, veuillez ne pas répondre à cet email.";

        return mailBody;
    }
}
