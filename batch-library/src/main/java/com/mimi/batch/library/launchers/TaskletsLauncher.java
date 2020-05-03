package com.mimi.batch.library.launchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableBatchProcessing
@EnableScheduling
public class TaskletsLauncher {

    private final Logger LOGGER = LogManager.getLogger( TaskletsLauncher.class );

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("taskletsJob")
    private Job job;

    /*
        Scheduled every day at 01:00 am
        @Scheduled(cron="0 0 1 * * ?")
    */

    //Scheduled every 1 minute
    @Scheduled(cron = "0 */1 * * * ?")
    public void launchJob() throws Exception {
        Date date = new Date();

        LOGGER.debug( "scheduler starts at " + date );
        JobExecution jobExecution = jobLauncher.run( job, new JobParametersBuilder().addDate("launchDate", date )
                .toJobParameters());

        LOGGER.debug( "Batch job ends with status as " + jobExecution.getStatus() );
        LOGGER.debug( "scheduler ends " );
    }

}
