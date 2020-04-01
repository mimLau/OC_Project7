package com.mimi.mlibrary.controllers;

import com.mimi.mlibrary.model.dto.borrowing.BorrowingDto;
import com.mimi.mlibrary.model.entity.borrowing.Borrowing;
import com.mimi.mlibrary.service.contract.BorrowingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping( params = "id" )
    public BorrowingDto findBorrowingById( @RequestParam(required = true) int id ) {
        return borrowingService.findBorrowingById( id );
    }

    @GetMapping( value = "/Members", params = "id" )
    public List<BorrowingDto> findAllByMemberId( @RequestParam(required = true) int id ) {
        return borrowingService.findByMemberId( id );
    }

    @PostMapping( params = { "memberId", "copyId" } )
    public ResponseEntity<Void> addBorrowing( @RequestBody Borrowing borrowing, @RequestParam(required = true) int memberId, @RequestParam(required = true) int copyId  ) {
        BorrowingDto addedBorrowing = borrowingService.save( borrowing, memberId, copyId);
        if( addedBorrowing == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedBorrowing.getId() ).toUri();
        return ResponseEntity.created( location ).build();
    }

    @PutMapping( value = "/return", params = "id" )
    public void updateBorrowingReturnDate( @RequestParam(required = true) int id ) {
        borrowingService.updateBorrowingReturnDateById( id );
    }

    @PutMapping( value = "/status", params = "id" )
    public void updateBorrowingStatus( @RequestParam(required = true) int id ) {
        borrowingService.updateBorrowingStatus( id );
    }


}
