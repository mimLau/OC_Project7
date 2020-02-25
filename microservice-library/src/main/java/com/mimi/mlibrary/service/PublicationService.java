package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.dest.publication.BookDto;
import com.mimi.mlibrary.model.source.publication.Publication;
import com.mimi.mlibrary.model.dest.publication.PublicationDto;

import java.util.List;
import java.util.Optional;

public interface PublicationService {

    List<PublicationDto> findAll();
    List<BookDto> findAllBooks();
    Publication findByIsbn( String isbn );
    List<Publication> findAllByAuthor( String name );
    List<PublicationDto> findAllByTitle(String title );
    Optional<Publication> findById( int id);

}
