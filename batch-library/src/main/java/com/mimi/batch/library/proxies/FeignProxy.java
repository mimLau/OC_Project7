package com.mimi.batch.library.proxies;

import com.mimi.batch.library.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@FeignClient( name = "library-webservice", url = "localhost:8080" )
public interface FeignProxy {


    @GetMapping( "/Loans/delay/email" )
    Map<String, LocalDate> getOutdatedLoansAndEmailMember( @RequestHeader("Authorization") String token );

    @GetMapping( "/Loans/delay" )
    List<Loan> getOutdatedLoanLists( @RequestHeader("Authorization") String token );

}