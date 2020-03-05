package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.dest.publication.*;
import com.mimi.mlibrary.model.source.publication.*;
import org.joda.time.LocalDate;

import java.util.List;
import java.util.Optional;

public interface PublicationService {


    List<BookDto> findAllBooks();

    List<NewspaperDto> findAllNewspapers();
    List<NewspaperDto> findAllNewspapersByDate(LocalDate date );

    List<ReviewDto> findAllReviews();
    List<ReviewDto> findAllReviewsByDate( LocalDate date );

    PublicationDto findPublicationById(int id );
    List<PublicationDto> findAllPublications();
    List<PublicationDto> findAllByTitle(String title );
    List<PublicationDto> findAllByAuthor( String name );
    List<PublicationDto> findAllByAuthorId( int id );
    PublicationDto findByIsbn( String isbn );

    List<AuthorDto> findAllAuthor();
    AuthorDto saveAuthor( AuthorDto authorDto );
    void deleteAuthorById( int id );

    CopyDto findCopyById(int id );
    List<CopyDto> findAllCopy();
    List<CopyDto> findAllCopyByPublicationId( int id );
    List<CopyDto> findAllCopyByDelay();
    void  updateCopyReturnDateById( LocalDate newDate, int id );



}
