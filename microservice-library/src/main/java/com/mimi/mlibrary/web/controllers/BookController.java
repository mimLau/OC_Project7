package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.source.publication.Book;
import com.mimi.mlibrary.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping( value = "/BookByAuthor/{name}")
    public List<Book> findAllByAuthor(@PathVariable String name) {
        return bookService.findAllByAuthor( name );
    }

    @GetMapping( value = "/BookByTitle/{title}")
    public List<Book> findAllByTitle(@PathVariable String title) {
        return bookService.findAllByTitle( title );
    }
}
