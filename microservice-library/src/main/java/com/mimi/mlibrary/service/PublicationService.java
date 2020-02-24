package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.publication.Publication;
import com.mimi.mlibrary.model.publication.PublicationDto;

import java.util.List;
import java.util.Optional;

public interface PublicationService {

    List<PublicationDto> findAll();
    Publication findByIsbn( String isbn );
    List<Publication> findAllByAuthor( String name );
    List<PublicationDto> findAllByTitle(String title );
    Optional<Publication> findById( int id);

}
