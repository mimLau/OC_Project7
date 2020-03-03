package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.publication.*;
import com.mimi.mlibrary.mapper.publication.BookMapper;
import com.mimi.mlibrary.mapper.publication.PublicationMapper;
import com.mimi.mlibrary.model.dest.publication.BookDto;
import com.mimi.mlibrary.model.dest.publication.CopyDto;
import com.mimi.mlibrary.model.dest.publication.PublicationDto;
import com.mimi.mlibrary.model.source.publication.*;
import com.mimi.mlibrary.service.PublicationService;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationDao publicationDao;
    private PublicationMapper publicationMapper;
    private BookMapper bookMapper;


    private AuthorDao authorDao;
    private CopyDao copyDao;


    PublicationServiceImpl(PublicationDao publicationDao, PublicationMapper publicationMapper, AuthorDao authorDao, CopyDao copyDao, BookMapper bookMapper) {
        this.publicationDao = publicationDao;
        this.publicationMapper = publicationMapper;
        this.authorDao = authorDao;
        this.copyDao = copyDao;
        this.bookMapper = bookMapper;
    }



    /****************
     * Books
     * **************/

    @Override
    public List<BookDto> findAllBooks() {
        List<Book> books = publicationDao.findAllBooks();
        List<BookDto> bookDtos = bookMapper.map( books );
        return bookDtos;
    }


    /****************
     * Newspapers
     * **************/

    @Override
    public List<Newspaper> findAllNewspapers() {
        return publicationDao.findAllNewspapers();
    }

    @Override
    public List<Newspaper> findAllNewspapersByDate( LocalDate date ) {
        //TODO convert date or something like this
        return publicationDao.findAllNewspaperByDate( date );
    }



    /****************
     * Reviews
     * **************/

    @Override
    public List<Review> findAllReviews() {
        return publicationDao.findAllReviews();
    }

    @Override
    public List<Review> findAllReviewsByDate( LocalDate date ) {
        return publicationDao.findAllReviewsByDate( date );
    }



    /****************
     * Publications
     * **************/


    @Override
    public Optional<Publication> findPublicationById( int id ) {
        return publicationDao.findPublicationById( id );
    }

    @Override
    public List<Publication> findAllPublications() {
        return publicationDao.findAllPublications();
    }

    @Override
    public List<PublicationDto> findAllByTitle( String title ) {
        List <PublicationDto> publicationDtos = publicationMapper.map( publicationDao.findAllByTitle( title ));
        return publicationDtos;
    }

    @Override
    public List<Publication> findAllByAuthor( String name ) {
        return publicationDao.findAllByAuthor( name );
    }

    @Override
    public List<Publication> findAllByAuthorId( int id ) {
        return publicationDao.findAllByAuthorId( id );
    }

    @Override
    public Publication findAllByIsbn( String idNb ) {
        return publicationDao.findAllByIsbn( idNb);
    }



    /****************
     * Authors
     * **************/

   @Override
    public List<Author> findAllAuthor() {
        return authorDao.findAll();
    }

    @Override
    public Author saveAuthor( Author author ) {
        return authorDao.save( author );
    }

    @Override
    public void deleteAuthorById( int id ) {
         authorDao.deleteAuthorById( id );
    }



    /****************
     * Copies
     * **************/

    @Override
    public List<Copy> findAllCopy() {
        return copyDao.findAll();
    }

    @Override
    public List<CopyDto> findAllCopyDto() {
        return null;
    }

    @Override
    public List<Copy> findAllCopyByPublicationId( int publicationId ) {
        return copyDao.findAllCopyByPublicationId( publicationId );
    }

    @Override
    public List<Copy> findAllCopyByDelay( ) {
        LocalDate localDate = new LocalDate();

        return copyDao.findAllByDelay( localDate );
    }

    @Override
    public void updateCopyReturnDateById( LocalDate newDate, int id) {
        copyDao.updateCopyReturnDateById( newDate, id );
    }


    @Override
    public Copy findCopyById( int id ) {
        return copyDao.findCopyById( id );
    }


}
