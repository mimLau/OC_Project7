package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.source.publication.Book;
import com.mimi.mlibrary.service.publication.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController( BookService bookService ) {
        this.bookService = bookService;
    }

    @GetMapping( value = "/Books" )
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping( value = "/Books", params = "name" )
    public List<Book> findAllByAuthor( @RequestParam String name ) {
        return bookService.findAllByAuthor( name );
    }

    @GetMapping( value = "/Books/", params = "title")
    public List<Book> findAllByTitle( @RequestParam String title ) {
        return bookService.findAllByTitle( title );
    }
}
