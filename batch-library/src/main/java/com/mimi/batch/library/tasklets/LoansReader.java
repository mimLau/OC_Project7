package com.mimi.batch.library.tasklets;

import com.mimi.batch.library.model.Loan;
import com.mimi.batch.library.proxies.FeignProxy;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public class LoansReader implements Tasklet {

    private List<Loan> loans;
    private FeignProxy proxy;
    private String token;

    public LoansReader( FeignProxy proxy, String token ) {
        this.proxy = proxy;
        this.token = token;
    }


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        loans =  this.proxy.getOutdatedLoanLists( token );
        return RepeatStatus.FINISHED;
    }
}
