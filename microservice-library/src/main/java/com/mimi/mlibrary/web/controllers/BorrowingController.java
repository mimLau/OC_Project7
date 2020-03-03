package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import com.mimi.mlibrary.service.BorrowingService;
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

    @PostMapping( value = "/Borrowings", params = { "memberId", "copyId" })
    public ResponseEntity<Void> addBorrowing( @RequestBody Borrowing borrowing, @RequestParam int memberId, @RequestParam int copyId  ) {
        Borrowing addedBorrowing = borrowingService.save( borrowing, memberId, copyId);
        if( addedBorrowing == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedBorrowing.getId() ).toUri();
        return ResponseEntity.created( location ).build();
    }

    @PutMapping( value = "/Borrowings-return", params = "id" )
    public void updateBorrowingReturnDate( @RequestParam int id ) {
        borrowingService.updateBorrowingReturnDateById( id );
    }

    @PutMapping( value = "/Borrowings-status", params = "id" )
    public void updateBorrowingStatus( @RequestParam int id ) {
        borrowingService.updateBorrowingStatus( id );
    }


}
