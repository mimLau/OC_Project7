package com.mimi.batch.library.config;

import com.mimi.batch.library.customItems.BorrowingItemReader;
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
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BorrowingBatchConfig {

    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    @Autowired private ItemReader<Borrowing> borrowingItemReader;
    @Autowired private ItemWriter<Borrowing> borrowingItemWriter;
    @Autowired private ItemProcessor<Borrowing, Borrowing> borrowingItemProcessor;


    private FeignProxy proxy;
    private AuthFeignProxy authProxy;

    public BorrowingBatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
                                FeignProxy proxy, AuthFeignProxy authProxy ) {

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
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Borrowing, Borrowing>chunk(100)
                .reader( borrowingItemReader )
                .processor(borrowingItemProcessor )
                .writer( borrowingItemWriter ).build();
    }

    @Bean
    public Job runJob() {
        return jobBuilderFactory.get("report generation")
                .flow(step1())
                .end()
                .build();
    }

}

