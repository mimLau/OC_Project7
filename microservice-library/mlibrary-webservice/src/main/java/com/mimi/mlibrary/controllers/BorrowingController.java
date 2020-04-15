package com.mimi.mlibrary.controllers;

import com.mimi.mlibrary.exceptions.ResourceNotFoundException;
import com.mimi.mlibrary.mapper.borrowing.BorrowingMapper;
import com.mimi.mlibrary.model.dto.borrowing.BorrowingDto;
import com.mimi.mlibrary.service.contract.BorrowingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/Borrowings")
public class BorrowingController {

    private BorrowingService borrowingService;

    public BorrowingController( BorrowingService borrowingService ) {
        this.borrowingService = borrowingService;
    }

    @GetMapping
    public List<BorrowingDto> getAllBorrowings() {
        return borrowingService.findAll();
    }

    @GetMapping( "/{id}" )
    public BorrowingDto findBorrowingById( @PathVariable int id ) {
        return borrowingService.findBorrowingById( id );
    }


    @GetMapping( "/Members/{id}" )
    public List<BorrowingDto> findAllByMemberId( @PathVariable int id ) {
        return borrowingService.findByMemberId( id );
    }

    @PostMapping( params = { "mbId", "cpId" },  consumes={"application/json"})
    public ResponseEntity<Void> addBorrowing( @RequestBody BorrowingDto borrowingDto, @RequestParam(required = true) int mbId, @RequestParam(required = true) int cpId  ) {
        BorrowingDto addedBorrowing = borrowingService.save( borrowingDto, mbId, cpId);

        if( addedBorrowing == null ) throw new ResourceNotFoundException( "L'utilisateur ne peut pas emprunter cette exemplaire.\n Exemplaire indisponible ou l'utilisateur a déjà 5 emprunts en cours." );

        /*if( addedBorrowing == null)
            return ResponseEntity.noContent().build();*/

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedBorrowing.getId() ).toUri();
        return ResponseEntity.created( location ).build();
    }

    @PutMapping( "/return/{borrowingId}" )
    public void extendBorrowingReturnDate( @PathVariable int borrowingId ) {
        borrowingService.extendBorrowingReturnDateById( borrowingId );
    }

    @PutMapping( "/status/{id}" )
    public void updateBorrowingStatus( @PathVariable int id ) {
        borrowingService.updateBorrowingStatus( id );
    }

    @GetMapping( "/delay" )
    public List<BorrowingDto> findByDelay() {
        return   borrowingService.findByDelay();
    }



}
