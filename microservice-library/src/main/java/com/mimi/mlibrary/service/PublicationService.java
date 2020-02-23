package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.publications.Publication;

import java.util.List;

public interface PublicationService {

    Publication findByIsbn( String isbn );
    List<Publication> findAllByAuthor( String name );
    List<Publication> findAllByTitle(String title );

}
