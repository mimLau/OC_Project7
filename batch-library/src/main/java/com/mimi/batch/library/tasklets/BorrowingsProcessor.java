package com.mimi.batch.library.tasklets;

import com.mimi.batch.library.model.Borrowing;
import com.mimi.batch.library.proxies.FeignProxy;
import com.mimi.batch.library.utils.MailUtil;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

public class BorrowingsProcessor implements Tasklet {

    @Autowired private MailUtil util;
    private List<Borrowing> borrowings;
    private FeignProxy proxy;
    private String token;

    public BorrowingsProcessor( FeignProxy proxy, String token  ) {
        this.proxy = proxy;
        this. token = token;
    }


    @Override
    public RepeatStatus execute( StepContribution contribution, ChunkContext chunkContext ) throws Exception {
        borrowings =  this.proxy.getOutdatedBorrowingLists( token );
        String msg = "";

        for( Borrowing borrowing : borrowings ) {
            msg = util.sendEmail(borrowing.getMember().getAccountOwnerEmail(), buildMessage(borrowing));
            System.out.println(msg);
        }


        return RepeatStatus.FINISHED;
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
