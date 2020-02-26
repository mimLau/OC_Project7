package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import com.mimi.mlibrary.service.borrowing.BorrowingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BorrowingController {

    private BorrowingService borrowingService;

    public BorrowingController( BorrowingService borrowingService ) {
        this.borrowingService = borrowingService;
    }

    @GetMapping( value = "/Borrowings/MemberId", params = "id")
    public List<Borrowing> findAllByUserId( @RequestParam int id ) {
        return borrowingService.findByMemberId( id );
    }

    @GetMapping( value = "/Borrowings")
    public List<Borrowing> getAllBorrowings() {
        return borrowingService.findAll();
    }
}
