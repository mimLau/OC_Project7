package com.mimi.batch.library.config;

import com.mimi.batch.library.model.Borrowing;
import com.mimi.batch.library.model.UserBatch;
import com.mimi.batch.library.proxies.AuthFeignProxy;
import com.mimi.batch.library.proxies.FeignProxy;
import com.mimi.batch.library.tasklets.BorrowingsProcessor;
import com.mimi.batch.library.tasklets.BorrowingsReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskletsConfig {

    private JobBuilderFactory jobs;
    private StepBuilderFactory steps;

    private FeignProxy proxy;
    private AuthFeignProxy authProxy;


    public TaskletsConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, FeignProxy proxy, AuthFeignProxy authProxy) {
        this.jobs = jobBuilderFactory;
        this.steps = stepBuilderFactory;
        this.authProxy = authProxy;
        this.proxy = proxy;
    }

   /* @Bean
    public BorrowingsReader borrowingsReader() {
        String token = authProxy.login( new UserBatch() );
        return new BorrowingsReader( proxy, token );
    }*/

    @Bean
    public BorrowingsProcessor borrowingsProcessor() {
        String token = authProxy.login( new UserBatch() );
        return new BorrowingsProcessor( proxy, token );
    }


    /*@Bean
    public Step readBorrowings() throws Exception {

        return steps.get("readBorrowings")
                .tasklet( borrowingsReader() )
                .build();
    }*/


    @Bean
    public Step processBorrowings() throws Exception {
        return steps.get("processBorrowings")
                .tasklet( borrowingsProcessor() )
                .build();
    }

    @Bean
    public Job taskletsJob() throws Exception {
        return this.jobs.get("taskletsJob")
                //.start( readBorrowings() )
                //.next( processBorrowings() )
                .start( processBorrowings() )
                .build();
    }
}
