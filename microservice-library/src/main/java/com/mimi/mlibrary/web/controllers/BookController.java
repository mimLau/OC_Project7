package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.source.publication.Book;
import com.mimi.mlibrary.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping( value = "/Book")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }
}
