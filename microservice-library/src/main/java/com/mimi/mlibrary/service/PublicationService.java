package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.publications.Publication;

import java.util.List;
import java.util.Optional;

public interface PublicationService {

    List<Publication> findAll();
    Publication findByIsbn( String isbn );
    List<Publication> findAllByAuthor( String name );
    List<Publication> findAllByTitle(String title );
    Optional<Publication> findById( int id);

}
