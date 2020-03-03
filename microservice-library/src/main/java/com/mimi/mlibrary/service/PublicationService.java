package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.dest.publication.BookDto;
import com.mimi.mlibrary.model.dest.publication.CopyDto;
import com.mimi.mlibrary.model.source.publication.*;
import com.mimi.mlibrary.model.dest.publication.PublicationDto;
import org.joda.time.LocalDate;

import java.util.List;
import java.util.Optional;

public interface PublicationService {


    List<BookDto> findAllBooks();

    List<Newspaper> findAllNewspapers();
    List<Newspaper> findAllNewspapersByDate( LocalDate date );

    List<Review> findAllReviews();
    List<Review> findAllReviewsByDate( LocalDate date );

    Optional<Publication> findPublicationById( int id );
    List<Publication> findAllPublications();
    //List<PublicationDto> findAllPublicationDto();
    List<PublicationDto> findAllByTitle(String title );
    List<Publication> findAllByAuthor( String name );
    List<Publication> findAllByAuthorId( int id );
    Publication findAllByIsbn( String isbn );

    List<Author> findAllAuthor();
    Author saveAuthor( Author author );
    void deleteAuthorById( int id );

    Copy findCopyById( int id );
    List<CopyDto> findAllCopyDto();
    List<Copy> findAllCopy();
    List<Copy> findAllCopyByPublicationId( int id );
    List<Copy> findAllCopyByDelay();
    void  updateCopyReturnDateById( LocalDate newDate, int id );



}
