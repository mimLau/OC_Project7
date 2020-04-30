package com.mimi.batch.library.config;

import com.mimi.batch.library.chuncks.LoanItemReader;
import com.mimi.batch.library.model.Loan;
import com.mimi.batch.library.model.UserBatch;
import com.mimi.batch.library.proxies.AuthFeignProxy;
import com.mimi.batch.library.proxies.FeignProxy;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChunksConfig {

    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    @Autowired private ItemReader<Loan> LoanItemReader;
    @Autowired private ItemWriter<Loan> LoanItemWriter;
    @Autowired private ItemProcessor<Loan, Loan> LoanItemProcessor;


    private FeignProxy proxy;
    private AuthFeignProxy authProxy;

    public ChunksConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
                        FeignProxy proxy, AuthFeignProxy authProxy ) {

        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;

        this.proxy = proxy;
        this.authProxy = authProxy;
    }


    @Bean
    ItemReader<Loan> LoanItemReader() {
        String token = authProxy.login( new UserBatch() );
        return new LoanItemReader( proxy, token );
    }


    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Loan, Loan>chunk(1)
                .reader( LoanItemReader )
                .processor(LoanItemProcessor )
                .writer( LoanItemWriter ).build();
    }

    @Bean
    public Job runJob() {
        return jobBuilderFactory.get("report generation")
                .flow(step1())
                .end()
                .build();
    }

}

