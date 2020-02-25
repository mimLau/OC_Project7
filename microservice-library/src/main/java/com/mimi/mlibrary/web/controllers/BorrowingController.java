package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.dest.borrowing.BorrowingDto;
import com.mimi.mlibrary.service.BorrowingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BorrowingController {

    private BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping( value = "/Borrowing")
    public List<BorrowingDto> getAllBorrowings() {
        return borrowingService.findAll();
    }
}
