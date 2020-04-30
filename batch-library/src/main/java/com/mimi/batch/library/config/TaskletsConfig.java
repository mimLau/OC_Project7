package com.mimi.batch.library.config;

import com.mimi.batch.library.model.Loan;
import com.mimi.batch.library.model.UserBatch;
import com.mimi.batch.library.proxies.AuthFeignProxy;
import com.mimi.batch.library.proxies.FeignProxy;
import com.mimi.batch.library.tasklets.LoansProcessor;
import com.mimi.batch.library.tasklets.LoansReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
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
    public LoansReader loansReader() {
        String token = authProxy.login( new UserBatch() );
        return new LoansReader( proxy, token );
    }*/

    @Bean
    public LoansProcessor loansProcessor() {
        String token = authProxy.login( new UserBatch() );
        return new LoansProcessor( proxy, token );
    }


    /*@Bean
    public Step readLoans() throws Exception {

        return steps.get("readLoans")
                .tasklet( loansReader() )
                .build();
    }*/


    @Bean
    public Step processLoans() throws Exception {
        return steps.get("processLoans")
                .tasklet( loansProcessor() )
                .build();
    }

    @Bean
    public Job taskletsJob() throws Exception {
        return this.jobs.get("taskletsJob")
                //.start( readLoans() )
                //.next( processLoans() )
                .start( processLoans() )
                .build();
    }
}
