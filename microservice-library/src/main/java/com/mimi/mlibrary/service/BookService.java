package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.source.publication.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
}
