package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.publication.AuthorDao;
import com.mimi.mlibrary.dao.publication.CopyDao;
import com.mimi.mlibrary.dao.publication.PublicationDao;
import com.mimi.mlibrary.mapper.publication.*;
import com.mimi.mlibrary.model.dest.publication.*;
import com.mimi.mlibrary.model.source.publication.*;
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
        List<Book> books = publicationDao.findAllBooks();
        List<BookDto> bookDtos = bookMapper.map( books );
        return bookDtos;
    }


    /****************
     * Newspapers
     * **************/

    @Override
    public List<NewspaperDto> findAllNewspapers() {
        List<Newspaper> newspapers = publicationDao.findAllNewspapers();
        List<NewspaperDto> newspaperDtos = newspaperMapper.map( newspapers );
        return newspaperDtos;
    }

    @Override
    public List<NewspaperDto> findAllNewspapersByDate( LocalDate date ) {

        List<Newspaper> newspapers = publicationDao.findAllNewspaperByDate( date );
        List<NewspaperDto> newspaperDtos = newspaperMapper.map( newspapers );

        //TODO convert date or something like this
        return newspaperDtos;
    }



    /****************
     * Reviews
     * **************/

    @Override
    public List<ReviewDto> findAllReviews() {
        List<Review> reviews = publicationDao.findAllReviews();
        List<ReviewDto> reviewDtos = reviewMapper.map( reviews );
        return reviewDtos;
    }

    @Override
    public List<ReviewDto> findAllReviewsByDate( LocalDate date ) {
        List<Review> reviews = publicationDao.findAllReviewsByDate( date );
        List<ReviewDto> reviewDtos = reviewMapper.map( reviews );
        return reviewDtos;
    }



    /****************
     * Publications
     * **************/


    @Override
    public PublicationDto findPublicationById( int id ) {
        Optional<Publication> publication = publicationDao.findPublicationById( id );
        PublicationDto publicationDto = publicationMapper.map( publication.get() );
        return publicationDto;
    }

    @Override
    public List<PublicationDto> findAllPublications() {
        List<Publication> publications =  publicationDao.findAllPublications();
        List<PublicationDto> publicationDtos =publicationMapper.map( publications );
        return publicationDtos;
    }

    @Override
    public List<PublicationDto> findAllByTitle( String title ) {
        List <PublicationDto> publicationDtos = publicationMapper.map( publicationDao.findAllByTitle( title ));
        return publicationDtos;
    }

    @Override
    public List<PublicationDto> findAllByAuthor( String name ) {
        List<Publication> publications =  publicationDao.findAllByAuthor( name );
        List<PublicationDto> publicationDtos =publicationMapper.map( publications );
        return publicationDtos;
    }

    @Override
    public List<PublicationDto> findAllByAuthorId( int id ) {
        List<Publication> publications =  publicationDao.findAllByAuthorId( id );
        List<PublicationDto> publicationDtos =publicationMapper.map( publications );
        return publicationDtos;
    }

    @Override
    public PublicationDto findAllByIsbn( String idNb ) {
        Optional<Publication> publication = publicationDao.findAllByIsbn( idNb);
        PublicationDto publicationDto = publicationMapper.map( publication.get() );
        return publicationDto;
    }



    /****************
     * Authors
     * **************/

   @Override
    public List<AuthorDto> findAllAuthor() {
       List <Author> authors = authorDao.findAll();
       List<AuthorDto> authorDtos = authorMapper.map( authors );
       return authorDtos;
    }

    @Override
    public AuthorDto saveAuthor( Author author ) {
        Author savedAuthor = authorDao.save( author );
        AuthorDto authorDto = authorMapper.map( savedAuthor );
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
        List<Copy> copies = copyDao.findAll();
        List<CopyDto> copyDtos = copyMapper.map( copies );
        return copyDtos;
    }

    @Override
    public List<CopyDto> findAllCopyByPublicationId( int publicationId ) {
        List<Copy> copies = copyDao.findAllCopyByPublicationId( publicationId );
        List<CopyDto> copyDtos = copyMapper.map( copies );

        return copyDtos;
    }

    @Override
    public List<CopyDto> findAllCopyByDelay( ) {
        LocalDate localDate = new LocalDate();
        List<Copy> copies = copyDao.findAllByDelay( localDate );
        List<CopyDto> copyDtos = copyMapper.map( copies );
        return copyDtos;
    }

    @Override
    public void updateCopyReturnDateById( LocalDate newDate, int id) {
        copyDao.updateCopyReturnDateById( newDate, id );
    }


    @Override
    public CopyDto findCopyById( int id ) {
        Optional<Copy> copy = copyDao.findCopyById( id );
        CopyDto copyDto = copyMapper.map( copy.get() );
        return copyDto;
    }

}
