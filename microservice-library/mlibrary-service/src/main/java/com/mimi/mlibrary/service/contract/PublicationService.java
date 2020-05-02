package com.mimi.mlibrary.service.contract;

import com.mimi.mlibrary.model.dto.publication.*;

import java.util.List;

public interface PublicationService {

    List<LibraryDto> findAllLibraries();
    List<PublicationDto> findAllByCriteria(String author, String title, String category, String editor, int libId );
    PublicationDto findPublicationById( int id );
    List<PublicationDto> findAllPublications();

    List<AuthorDto> findAllAuthor();
    AuthorDto saveAuthor( AuthorDto authorDto );
    void deleteAuthorById( int id );

    CopyDto findCopyById( int id );
    List<CopyDto> findAllCopyByPublicationId( int id );
    List<CopyDto> findAllCopyByDelay();
    List<CopyDto> findAvailableCopiesByLibrary( int libId );


}
