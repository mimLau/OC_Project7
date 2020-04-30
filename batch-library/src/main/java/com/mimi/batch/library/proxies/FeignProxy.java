package com.mimi.batch.library.proxies;

import com.mimi.batch.library.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient( name = "library-webservice", url = "localhost:8080" )
public interface FeignProxy {

    @GetMapping( "/Loans/delay" )
    List<Loan> getOutdatedLoanLists( @RequestHeader("Authorization") String token );

    @PutMapping( "/Loans/reminderNb/{loanId}" )
    void updateReminderNbById( @PathVariable int loanId, @RequestHeader("Authorization") String token  );

}