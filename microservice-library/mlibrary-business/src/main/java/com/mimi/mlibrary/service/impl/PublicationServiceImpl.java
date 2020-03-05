package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.publication.AuthorDao;
import com.mimi.mlibrary.dao.publication.CopyDao;
import com.mimi.mlibrary.dao.publication.PublicationDao;
import com.mimi.mlibrary.mapper.publication.*;
import com.mimi.mlibrary.model.dest.publication.*;
import com.mimi.mlibrary.model.source.publication.Author;
import com.mimi.mlibrary.service.PublicationService;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImpl implements PublicationService {


    private PublicationMapper publicationMapper;
    private BookMapper bookMapper;
    private NewspaperMapper newspaperMapper;
    private ReviewMapper reviewMapper;
    private CopyMapper copyMapper;
    private AuthorMapper authorMapper;

    private PublicationDao publicationDao;
    private AuthorDao authorDao;
    private CopyDao copyDao;


    PublicationServiceImpl(PublicationDao publicationDao, PublicationMapper publicationMapper, AuthorDao authorDao, CopyDao copyDao, BookMapper bookMapper, NewspaperMapper newspaperMapper, ReviewMapper reviewMapper, CopyMapper copyMapper, AuthorMapper authorMapper) {
        this.publicationDao = publicationDao;
        this.publicationMapper = publicationMapper;
        this.authorDao = authorDao;
        this.copyDao = copyDao;
        this.bookMapper = bookMapper;
        this.newspaperMapper = newspaperMapper;
        this.reviewMapper = reviewMapper;
        this.copyMapper = copyMapper;
        this.authorMapper = authorMapper;
    }



    /****************
     * Books
     * **************/

    @Override
    public List<BookDto> findAllBooks() {
        return bookMapper.bookToDtoList( publicationDao.findAllBooks() );
    }


    /****************
     * Newspapers
     * **************/

    @Override
    public List<NewspaperDto> findAllNewspapers() {
        return newspaperMapper.newsToDtoList( publicationDao.findAllNewspapers() );
    }

    @Override
    public List<NewspaperDto> findAllNewspapersByDate( LocalDate date ) {
        //TODO convert date or something like this
        return newspaperMapper.newsToDtoList( publicationDao.findAllNewspaperByDate( date ) );
    }



    /****************
     * Reviews
     * **************/

    @Override
    public List<ReviewDto> findAllReviews() {
        return reviewMapper.reviewToDtoList( publicationDao.findAllReviews());
    }

    @Override
    public List<ReviewDto> findAllReviewsByDate( LocalDate date ) {
        return reviewMapper.reviewToDtoList( publicationDao.findAllReviewsByDate( date ) );
    }



    /****************
     * Publications
     * **************/


    @Override
    public PublicationDto findPublicationById( int id ) {
        return publicationMapper.INSTANCE.pubToDto( publicationDao.findPublicationById( id ).orElse( null ));
    }

    @Override
    public List<PublicationDto> findAllPublications() {
        return  publicationMapper.pubToDtoList( publicationDao.findAllPublications());
    }

    @Override
    public List<PublicationDto> findAllByTitle( String title ) {
       return  publicationMapper.pubToDtoList( publicationDao.findAllByTitle( title ));
    }

    @Override
    public List<PublicationDto> findAllByAuthor( String name ) {
        return publicationMapper.pubToDtoList( publicationDao.findAllByAuthor( name ) );
    }

    @Override
    public List<PublicationDto> findAllByAuthorId( int id ) {
        return publicationMapper.pubToDtoList( publicationDao.findAllByAuthorId( id ) );
    }

    @Override
    public PublicationDto findByIsbn( String idNb ) {
        return publicationMapper.pubToDto( publicationDao.findAllByIsbn( idNb).orElse( null ));
    }



    /****************
     * Authors
     * **************/

   @Override
    public List<AuthorDto> findAllAuthor() {
       return authorMapper.authToDtoList( authorDao.findAll() );
    }

    @Override
    public AuthorDto saveAuthor( AuthorDto authorDto ) {

       Optional.of( AuthorMapper.INSTANCE.dtoToAuth( authorDto ) ).ifPresent( author -> authorDao.save( author ) );
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
        return copyMapper.copyTodtoList( copyDao.findAll() );
    }

    @Override
    public List<CopyDto> findAllCopyByPublicationId( int publicationId ) {
        return copyMapper.copyTodtoList( copyDao.findAllCopyByPublicationId( publicationId ) );
    }

    @Override
    public List<CopyDto> findAllCopyByDelay( ) {
        LocalDate localDate = new LocalDate();
        return copyMapper.copyTodtoList( copyDao.findAllByDelay( localDate ) );
    }

    @Override
    public void updateCopyReturnDateById( LocalDate newDate, int id) {
        copyDao.updateCopyReturnDateById( newDate, id );
    }


    @Override
    public CopyDto findCopyById( int id ) {
        return copyMapper.copyToDto( copyDao.findCopyById( id ).orElse(null) );
    }

}
