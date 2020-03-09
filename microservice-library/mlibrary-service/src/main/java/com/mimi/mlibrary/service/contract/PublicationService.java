package com.mimi.mlibrary.service.contract;

import com.mimi.mlibrary.model.dto.publication.*;
import java.time.LocalDate;

import java.util.Date;
import java.util.List;

public interface PublicationService {

    List<LibraryDto> findAllLibraries();

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
