package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import com.mimi.mlibrary.service.BorrowingService;
import org.joda.time.LocalDate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class BorrowingController {

    private BorrowingService borrowingService;

    public BorrowingController( BorrowingService borrowingService ) {
        this.borrowingService = borrowingService;
    }

    @GetMapping( value = "/Borrowings" )
    public List<Borrowing> getAllBorrowings() {
        return borrowingService.findAll();
    }

    @GetMapping( value = "/Borrowings", params = "id" )
    public Borrowing findBorrowingById( @RequestParam int id ) {
        return borrowingService.findBorrowingById( id );
    }

    @GetMapping( value = "/Borrowings/Members", params = "id" )
    public List<Borrowing> findAllByMemberId( @RequestParam int id ) {
        return borrowingService.findByMemberId( id );
    }

    @PostMapping( value = "/Borrowings" )
    public ResponseEntity<Void> addBorrowing( @RequestBody Borrowing borrowing ) {
        Borrowing addedBorrowing = borrowingService.save( borrowing );
        if( addedBorrowing == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedBorrowing.getId() ).toUri();
        return ResponseEntity.created( location ).build();
    }


    @PutMapping( value = "/Borrowings", params = { "days", "id" } )
    public void updateBorrowingReturnDateById( @RequestParam int days , @RequestParam int id ) {
        borrowingService.updateBorrowingReturnDateById( days, id );
    }

}
