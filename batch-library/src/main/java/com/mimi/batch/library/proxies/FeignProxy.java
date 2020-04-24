package com.mimi.batch.library.proxies;

import com.mimi.batch.library.model.Borrowing;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@FeignClient( name = "library-webservice", url = "localhost:8080" )
public interface FeignProxy {


    @GetMapping( "/Borrowings/delay/email" )
    Map<String, LocalDate> getOutdatedBorrowingsAndEmailMember( @RequestHeader("Authorization") String token );

    @GetMapping( "/Borrowings/delay" )
    List<Borrowing> getOutdatedBorrowingLists( @RequestHeader("Authorization") String token );

}