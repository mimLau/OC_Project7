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

    private LoanService LoanService;

    public LoanController( LoanService LoanService ) {
        this.LoanService = LoanService;
    }

    @GetMapping
    public List<LoanDto> getAllLoans() {
        return LoanService.findAll();
    }

    @GetMapping( "/{id}" )
    public LoanDto findLoanById( @PathVariable int id ) {
        return LoanService.findLoanById( id );
    }


    @GetMapping( "/Members/{id}" )
    public List<LoanDto> findAllLoansByMemberId( @PathVariable int id ) {
        return LoanService.findByMemberId( id );
    }

    @PostMapping( consumes={"application/json"})
    public ResponseEntity<Void> addLoan(@RequestBody LoanJson LoanJson ) {

        LoanDto addedLoan = LoanService.save( LoanJson.getMember(), LoanJson.getCopy() );

        if( addedLoan == null ) throw new ResourceNotFoundException( "L'utilisateur ne peut pas emprunter cette exemplaire.\n Exemplaire indisponible ou l'utilisateur a déjà 5 emprunts en cours." );

        /*if( addedLoan == null)
            return ResponseEntity.noContent().build();*/

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedLoan.getId() ).toUri();
        return ResponseEntity.created( location ).build();
    }

    @PutMapping( "/returnDate/{LoanId}" )
    public void extendLoanReturnDate( @PathVariable int LoanId ) {
        LoanService.extendLoanReturnDateById( LoanId );
    }

    @PutMapping( "/status/{id}" )
    public void updateLoanStatus( @PathVariable int id ) {
        LoanService.updateLoanStatus( id );
    }

    @GetMapping( "/delay" )
    public List<LoanDto> findByDelay() {
       return LoanService.findByDelay();
    }

    @GetMapping( "/delay/email" )
    public Map<String, LocalDate> getOutdatedLoansAndEmailMember() {
        return  LoanService.findOutdatedLoansEmailMember();
    }


}

