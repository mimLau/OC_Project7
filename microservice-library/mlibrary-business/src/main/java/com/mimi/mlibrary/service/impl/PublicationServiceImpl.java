package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.publication.AuthorDao;
import com.mimi.mlibrary.dao.publication.CopyDao;
import com.mimi.mlibrary.dao.publication.PublicationDao;
import com.mimi.mlibrary.mapper.publication.*;
import com.mimi.mlibrary.model.dest.publication.*;
import com.mimi.mlibrary.service.PublicationService;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationDao publicationDao;
    private AuthorDao authorDao;
    private CopyDao copyDao;


    PublicationServiceImpl( PublicationDao publicationDao, AuthorDao authorDao, CopyDao copyDao ) {
        this.publicationDao = publicationDao;
        this.authorDao = authorDao;
        this.copyDao = copyDao;
    }



    /****************
     * Books
     * **************/

    @Override
    public List<BookDto> findAllBooks() {
        return BookMapper.INSTANCE.toDtoList( publicationDao.findAllBooks() );
    }


    /****************
     * Newspapers
     * **************/

    @Override
    public List<NewspaperDto> findAllNewspapers() {
        return NewspaperMapper.INSTANCE.toDtoList( publicationDao.findAllNewspapers() );
    }

    @Override
    public List<NewspaperDto> findAllNewspapersByDate( LocalDate date ) {
        //TODO convert date or something like this
        return NewspaperMapper.INSTANCE.toDtoList( publicationDao.findAllNewspaperByDate( date ) );
    }



    /****************
     * Reviews
     * **************/

    @Override
    public List<ReviewDto> findAllReviews() {
        return ReviewMapper.INSTANCE.toDtoList( publicationDao.findAllReviews());
    }

    @Override
    public List<ReviewDto> findAllReviewsByDate( LocalDate date ) {
        return ReviewMapper.INSTANCE.toDtoList( publicationDao.findAllReviewsByDate( date ) );
    }



    /****************
     * Publications
     * **************/


    @Override
    public PublicationDto findPublicationById( int id ) {
        return PublicationMapper.INSTANCE.toDto( publicationDao.findPublicationById( id ).orElse( null ));
    }

    @Override
    public List<PublicationDto> findAllPublications() {
        return  PublicationMapper.INSTANCE.toDtoList( publicationDao.findAllPublications());
    }

    @Override
    public List<PublicationDto> findAllByTitle( String title ) {
       return  PublicationMapper.INSTANCE.toDtoList( publicationDao.findAllByTitle( title ));
    }

    @Override
    public List<PublicationDto> findAllByAuthor( String name ) {
        return PublicationMapper.INSTANCE.toDtoList( publicationDao.findAllByAuthor( name ) );
    }

    @Override
    public List<PublicationDto> findAllByAuthorId( int id ) {
        return PublicationMapper.INSTANCE.toDtoList( publicationDao.findAllByAuthorId( id ) );
    }

    @Override
    public PublicationDto findByIsbn( String idNb ) {
        return PublicationMapper.INSTANCE.toDto( publicationDao.findAllByIsbn( idNb).orElse( null ));
    }



    /****************
     * Authors
     * **************/

   @Override
    public List<AuthorDto> findAllAuthor() {
       return AuthorMapper.INSTANCE.toDtoList( authorDao.findAll() );
    }

    @Override
    public AuthorDto saveAuthor( AuthorDto authorDto ) {

       Optional.of( AuthorMapper.INSTANCE.toEntity( authorDto ) ).ifPresent( author -> authorDao.save( author ) );
       //authorDao.save( AuthorMapper.INSTANCE.dtoToAuth( authorDto ));
       return authorDto;
    }

    @Override
    public void deleteAuthorById( int id ) {
         authorDao.deleteAuthorById( id );
    }



    /****************
     * Copies
     * **************/

    @Override
    public List<CopyDto> findAllCopy() {
        return CopyMapper.INSTANCE.toDtoList( copyDao.findAll() );
    }

    @Override
    public List<CopyDto> findAllCopyByPublicationId( int publicationId ) {
        return CopyMapper.INSTANCE.toDtoList( copyDao.findAllCopyByPublicationId( publicationId ) );
    }

    @Override
    public List<CopyDto> findAllCopyByDelay( ) {
        LocalDate localDate = new LocalDate();
        return CopyMapper.INSTANCE.toDtoList( copyDao.findAllByDelay( localDate ) );
    }

    @Override
    public void updateCopyReturnDateById( LocalDate newDate, int id) {
        copyDao.updateCopyReturnDateById( newDate, id );
    }


    @Override
    public CopyDto findCopyById( int id ) {
        return CopyMapper.INSTANCE.toDto( copyDao.findCopyById( id ).orElse(null) );
    }

}
