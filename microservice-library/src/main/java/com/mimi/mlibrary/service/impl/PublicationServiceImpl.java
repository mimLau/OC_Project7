package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.PublicationDao;
import com.mimi.mlibrary.mapper.publication.PublicationMapper;
import com.mimi.mlibrary.model.source.publication.Publication;
import com.mimi.mlibrary.model.dest.publication.PublicationDto;
import com.mimi.mlibrary.service.PublicationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationDao publicationDao;
    private PublicationMapper publicationMapper;

    PublicationServiceImpl( PublicationDao publicationDao, PublicationMapper publicationMapper) {
        this.publicationDao = publicationDao;
        this.publicationMapper = publicationMapper;
    }

  /* public List<Publication> findAll() {
        return publicationDao.findAll();
    }*/

    public List<PublicationDto> findAll() {
        List<Publication> publications = publicationDao.findAll();
        List <PublicationDto> publicationDtos = publicationMapper.map(publications );

        return publicationDtos;
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
    /*public List<Publication> findAllByTitle( String title ) {
        return publicationDao.findAllByTitle( title );
    }*/

    public List<PublicationDto> findAllByTitle( String title ) {
        List <PublicationDto> publicationDtos = publicationMapper.map( publicationDao.findAllByTitle( title ));
        return publicationDtos;
    }
}
