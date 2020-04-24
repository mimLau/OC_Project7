package com.mimi.batch.library.config;

import com.mimi.batch.library.CustomReaders.BorrowingItemReader;
import com.mimi.batch.library.model.Borrowing;
import com.mimi.batch.library.model.UserBatch;
import com.mimi.batch.library.proxies.AuthFeignProxy;
import com.mimi.batch.library.proxies.FeignProxy;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.HashMap;
import java.util.Map;

@Configuration
//@EnableBatchProcessing
public class BatchConfig {

    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    private FeignProxy proxy;
    private AuthFeignProxy authProxy;

    public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, FeignProxy proxy, AuthFeignProxy authProxy) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;

        this.proxy = proxy;
        this.authProxy = authProxy;
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

        return stepBuilderFactory.get("step1").<Borrowing, Borrowing>chunk(100).reader( borrowingItemReader() )
                .writer( writer()).build();
    }

    @Bean
    public Job runJob() {
        return jobBuilderFactory.get("report generation").flow( step1() ).end().build();
    }
}
