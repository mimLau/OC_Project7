package com.mimi.mlibrary.controllers;

import com.mimi.mlibrary.exceptions.ResourceNotFoundException;
import com.mimi.mlibrary.model.dto.loan.LoanDto;
import com.mimi.mlibrary.model.entity.loan.LoanJson;
import com.mimi.mlibrary.service.contract.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Loans")
public class LoanController {

    private LoanService loanService;

    public LoanController( LoanService loanService ) {
        this.loanService = loanService;
    }

    @GetMapping
    public List<LoanDto> getAllLoans() {
        return loanService.findAll();
    }

    @GetMapping( "/{id}" )
    public LoanDto findLoanById( @PathVariable int id ) {
        return loanService.findLoanById( id );
    }


    @GetMapping( "/Members/{id}" )
    public List<LoanDto> findAllLoansByMemberId( @PathVariable int id ) {
        return loanService.findByMemberId( id );
    }

    @PostMapping( consumes={"application/json"})
    public ResponseEntity<Void> addLoan( @RequestBody LoanJson loanJson ) {

        LoanDto addedLoan = loanService.save( loanJson.getMember(), loanJson.getCopy() );
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedLoan.getId() ).toUri();
        return ResponseEntity.created( location ).build();
    }

    @PutMapping( "/returnDate/{LoanId}" )
    public void extendLoanReturnDate( @PathVariable int LoanId ) {
        loanService.extendLoanReturnDateById( LoanId );
    }

    @PutMapping( "/status/{loanId}" )
    public void updateLoanStatus( @PathVariable int loanId ) {
        loanService.updateLoanStatus( loanId );
    }

    @PutMapping( value = "/reminderNb/{loanId}" )
    public void updateReminderNbById( @PathVariable int loanId ) {
        loanService.updateReminderNbById( loanId );
    }

    @GetMapping( "/delay" )
    public List<LoanDto> findByDelay() {
       return loanService.findByDelay();
    }

}

