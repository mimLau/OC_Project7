package com.mimi.mlibrary.service.contract;

import com.mimi.mlibrary.model.dto.publication.*;
import com.mimi.mlibrary.model.entity.publication.Category;
import com.mimi.mlibrary.model.entity.publication.Criteria;

import java.time.LocalDate;
import java.util.List;

public interface PublicationService {

    List<LibraryDto> findAllLibraries();
    List<PublicationDto> findAllByCriteria(String author, String title, Category category, LocalDate date, String editor, int libId );

    List<PublicationDto> findPublicationByCriteria( String criteria, String value, int libId );
    PublicationDto findPublicationById( int id );
    List<PublicationDto> findAllPublications();
    List<PublicationDto> findAllByAuthor( String name, int libId );
    List<PublicationDto> findAllByAuthor( String name );
    List<PublicationDto> findAllByAuthorId( int id );

    List<PublicationDto> findAllByTitle( String title, int libId );
    List<PublicationDto> findAllByExactTitle( String title, int libId );
    PublicationDto findByIsbn( String isbn );

    List<AuthorDto> findAllAuthor();
    AuthorDto saveAuthor( AuthorDto authorDto );
    void deleteAuthorById( int id );

    CopyDto findCopyById( int id );
    List<CopyDto> findAllCopy();
    List<CopyDto> findAllCopyByPublicationId( int id );
    List<CopyDto> findAllCopyByDelay();
    void updateCopyReturnDateById( LocalDate newDate, int id );
    List<CopyDto> findAvailableCopiesByLibrary( int libId );


}
