package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import com.mimi.mlibrary.service.borrowing.BorrowingService;
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

    @GetMapping( value = "/Borrowings/MemberId", params = "id" )
    public List<Borrowing> findAllByMemberId( @RequestParam int id ) {
        return borrowingService.findByMemberId( id );
    }

    @GetMapping( value = "/Borrowings" )
    public List<Borrowing> getAllBorrowings() {
        return borrowingService.findAll();
    }

    @PostMapping( value = "/Borrowings/add" )
    public ResponseEntity<Void> addBorrowing(@RequestBody Borrowing borrowing ) {
        Borrowing addedBorrowing = borrowingService.save( borrowing );
        if( addedBorrowing == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedBorrowing.getId() ).toUri();
        return ResponseEntity.created( location ).build();
    }


}
