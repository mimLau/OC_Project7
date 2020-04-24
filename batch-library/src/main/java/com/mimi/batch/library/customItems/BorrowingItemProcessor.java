package com.mimi.batch.library.customItems;

import com.mimi.batch.library.model.Borrowing;
import org.springframework.batch.item.ItemProcessor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.mimi.batch.library.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BorrowingItemProcessor implements ItemProcessor<Borrowing, Borrowing> {

   @Autowired private MailUtil util;

    @Override
    public Borrowing process(Borrowing borrowing) throws Exception {

        String msg = util.sendEmail(borrowing.getMember().getAccountOwnerEmail(), buildMessage( borrowing ));
        System.out.println(msg);
        return borrowing;
    }

    private String buildMessage( Borrowing borrowing ) {
        String mailBody = "Bonjour," + "\n"
                + "\n" + "- Date  : " + LocalDate.now()
                + "\n" + "- Nom de l'abonnée  : " + borrowing.getMember().getAccountOwnerLastname() + " " + borrowing.getMember().getAccountOwnerFirstname()
                + "\n" + "- Numéro de l'abonnée  : " + borrowing.getMember().getBarcode()
                + "\n" + "- Titre : " + borrowing.getCopy().getPublication().getTitle()
                + "\n" + "- No de document  : " + borrowing.getCopy().getPublication().getIdentificationNb()
                + "\n" + "- Échéance  : " + new SimpleDateFormat("dd/MM/yyyy").format(java.sql.Date.valueOf(borrowing.getReturnDate()))
                + "\n" + "\n" + "Nous vous remercions de bien vouloir rapporter au plus vite ce(s) document(s) dans l'une des bibliothèques municipales de Strasbourg."

                + "\n" + "\n" + "Ceci est un rappel automatique, veuillez ne pas répondre à cet email.";

        return mailBody;
    }
}
