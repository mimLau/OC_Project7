package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.dest.publication.BookDto;
import com.mimi.mlibrary.model.source.publication.*;
import com.mimi.mlibrary.model.dest.publication.PublicationDto;

import java.util.List;
import java.util.Optional;

public interface PublicationService {



    List<Author> findAllAuthor();
    Author saveAuthor( Author author );


    List<Book> findAllBook();
    List<Book> findAllBookByAuthor( String name );
    List<Book> findAllBookByTitle( String title );
    List<Book> findAllBookByAuthorId( int id );

    //List<CopyDto> findAll();
    List<Copy> findAllCopy();
    List<Copy> findAllCopyByBookId( int id );
    List<Copy> findAllCopyByReviewId( int id );
    List<Copy> findAllCopyByNewspaperId( int id );
    List<Copy> findAllCopyByDelay();


    List<Newspaper> findAllNewspaper();
    List<Newspaper> findAllNewspaperByName( String name );
    List<Newspaper> findAllNewspaperByDate( String date );

    List<Review> findAllReview();
    List<Review> findAllReviewByName( String name );
    List<Review> findAllReviewByDate( String date );




    /*List<PublicationDto> findAll();
    List<BookDto> findAllBooks();
    Publication findByIsbn( String isbn );
    List<Publication> findAllByAuthor( String name );
    List<PublicationDto> findAllByTitle(String title );
    Optional<Publication> findById( int id);*/

}
