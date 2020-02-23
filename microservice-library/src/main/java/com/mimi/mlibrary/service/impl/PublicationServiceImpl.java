package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.PublicationDao;
import com.mimi.mlibrary.model.publication.Publication;
import com.mimi.mlibrary.service.PublicationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationDao publicationDao;

    PublicationServiceImpl( PublicationDao publicationDao ) {
        this.publicationDao = publicationDao;
    }

    public List<Publication> findAll() {
        return publicationDao.findAll();
    }

    public Optional<Publication> findById( int id) {
        return publicationDao.findById( id );
    }


    @Override
    public Publication findByIsbn( String isbn ) {
        return publicationDao.findByIsbn( isbn );
    }

    @Override
    public List<Publication> findAllByAuthor( String name ) {
        return publicationDao.findAllByAuthor( name );
    }

    @Override
    public List<Publication> findAllByTitle( String title ) {
        return publicationDao.findAllByTitle( title );
    }
}
