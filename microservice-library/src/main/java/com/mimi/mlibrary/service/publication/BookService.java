package com.mimi.mlibrary.service.publication;

import com.mimi.mlibrary.model.source.publication.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
    List<Book> findAllByAuthor( String name );
    List<Book> findAllByTitle( String title );
    List<Book> findAllByAuthorId( int id );
}
