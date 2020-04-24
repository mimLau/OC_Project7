package com.mimi.batch.library.config;

import com.mimi.batch.library.customReaders.BorrowingItemReader;
import com.mimi.batch.library.model.Borrowing;
import com.mimi.batch.library.model.UserBatch;
import com.mimi.batch.library.proxies.AuthFeignProxy;
import com.mimi.batch.library.proxies.FeignProxy;
import com.mimi.batch.library.utils.MailUtil;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Configuration
//@EnableBatchProcessing
public class BatchConfig {

    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    private FeignProxy proxy;
    private AuthFeignProxy authProxy;
    private MailUtil util;

    public BatchConfig( JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
                        FeignProxy proxy, AuthFeignProxy authProxy, MailUtil util ) {

        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;

        this.proxy = proxy;
        this.authProxy = authProxy;
        this.util = util;
    }


    @Bean
    ItemReader<Borrowing> borrowingItemReader() {

        String token = authProxy.login( new UserBatch() );
        return new BorrowingItemReader( proxy, token );
    }


    @Bean
    public StaxEventItemWriter<Borrowing> writer() {
        StaxEventItemWriter<Borrowing> writer = new StaxEventItemWriter<Borrowing>();
        writer.setRootTagName( "Borrowings" );
        writer.setResource( new FileSystemResource("/xml/borrowings.xml") );
        writer.setMarshaller( marshaller() );
        return writer;
    }

    private XStreamMarshaller marshaller() {
        XStreamMarshaller marshaller = new XStreamMarshaller();
        Map<String, Class> map = new HashMap<>();
        map.put( "Borrowings", Borrowing.class );
        marshaller.setAliases( map );
        return marshaller;
    }

    @Bean
    public Step step1() {

        return stepBuilderFactory.get("step1").<Borrowing, Borrowing>chunk(100).reader(borrowingItemReader()).processor(process())
                .writer( writer()).build();
    }

    @Bean
    public Job runJob() {
        return jobBuilderFactory.get("report generation").flow( step1() ).end().build();
    }


    public ItemProcessor<Borrowing, Borrowing> process() {

        ItemProcessor<Borrowing, Borrowing> process = new ItemProcessor<>() {

            @Override
            public Borrowing process(Borrowing borrowing) throws Exception {

                String msg = util.sendEmail( borrowing.getMember().getAccountOwnerEmail(), buildMessage( borrowing ) );
                System.out.println(msg);
                return borrowing;
            }

            private String buildMessage (Borrowing borrowing ) {
                String mailBody = "Bonjour," + "\n"
                        +  "\n" + "- Date  : " + LocalDate.now()
                        +  "\n" + "- Nom de l'abonnée  : " + borrowing.getMember().getAccountOwnerLastname() + " " + borrowing.getMember().getAccountOwnerFirstname()
                        +  "\n" + "- Numéro de l'abonnée  : " +  borrowing.getMember().getBarcode()
                        +  "\n" + "- Titre : " + borrowing.getCopy().getPublication().getTitle()
                        +  "\n" + "- No de document  : " + borrowing.getCopy().getPublication().getIdentificationNb()
                        +  "\n" + "- Échéance  : " + new SimpleDateFormat("dd/MM/yyyy").format( java.sql.Date.valueOf(borrowing.getReturnDate()) )
                        +  "\n" + "Nous vous remercions de bien vouloir rapporter au plus vite ce(s) document(s) dans l'une des bibliothèques municipales de Strasbourg."

                        + "\n" +  "\n" + "Ceci est un rappel automatique, veuillez ne pas répondre à cet email.";

                return mailBody;
            }
        };

        return process;
    }
}

