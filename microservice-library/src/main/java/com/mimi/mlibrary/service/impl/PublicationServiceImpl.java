package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.dao.publication.*;
import com.mimi.mlibrary.model.source.publication.*;
import com.mimi.mlibrary.service.PublicationService;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {

    /*private PublicationDao publicationDao;
    private PublicationMapper publicationMapper;
    private BookMapper bookMapper;*/

    private AuthorDao authorDao;
    private BookDao bookDao;
    private CopyDao copyDao;
    private NewspaperDao newspaperDao;
    private ReviewDao reviewDao;

    PublicationServiceImpl(AuthorDao authorDao, BookDao bookDao, CopyDao copyDao, NewspaperDao newspaperDao, ReviewDao reviewDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
        this.copyDao = copyDao;
        this.newspaperDao = newspaperDao;
        this.reviewDao = reviewDao;
    }


    //Author
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


    //Book
    @Override
    public List<Book> findAllBook() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findAllBookByAuthor( String name ) {
        return bookDao.findAllByAuthor( name );
    }

    @Override
    public List<Book> findAllBookByTitle( String title ) {
        return bookDao.findAllByTitle( title );
    }

    @Override
    public List<Book> findAllBookByAuthorId( int id ) {
        return bookDao.findAllByAuthorId( id );
    }



    //Copy
    @Override
    public List<Copy> findAllCopy() {
        return copyDao.findAll();
    }

    @Override
    public List<Copy> findAllCopyByBookId(int bookId ) {
        return copyDao.findAllByBookId( bookId );
    }

    @Override
    public List<Copy> findAllCopyByReviewId( int reviewId ) {
        return copyDao.findAllByBookId( reviewId );
    }

    @Override
    public List<Copy> findAllCopyByNewspaperId( int newspaperId ) {
        return copyDao.findAllByBookId( newspaperId );
    }

    @Override
    public List<Copy> findAllCopyByDelay( ) {
        LocalDate localDate = new LocalDate();

        return copyDao.findAllByDelay( localDate );
    }



    //Newspaper
    @Override
    public List<Newspaper> findAllNewspaper() {
        return newspaperDao.findAll();
    }

    @Override
    public List<Newspaper> findAllNewspaperByName( String name ) {
        return newspaperDao.findAllByName( name );
    }

    @Override
    public List<Newspaper> findAllNewspaperByDate( String date ) {

        //TODO convert date or something like this
        return newspaperDao.findAllByDate( date );
    }


    //Review

    @Override
    public List<Review> findAllReview() {
        return reviewDao.findAll();
    }

    @Override
    public List<Review> findAllReviewByName( String name ) {
        return reviewDao.findAllByName( name );
    }

    @Override
    public List<Review> findAllReviewByDate( String date ) {
        return reviewDao.findAllByDate( date );
    }














  /* public List<Publication> findAll() {
        return publicationDao.findAll();
    }*/

    /*@Override
    public List<PublicationDto> findAll() {
        List<Publication> publications = publicationDao.findAll();
        List <PublicationDto> publicationDtos = publicationMapper.map(publications );

        return publicationDtos;
    }

    @Override
    public List<BookDto> findAllBooks() {
        List<Book> books = publicationDao.findAllBooks();
        List <BookDto> bookDtos = bookMapper.map( books );
        return bookDtos;
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

    /*public List<PublicationDto> findAllByTitle( String title ) {
        List <PublicationDto> publicationDtos = publicationMapper.map( publicationDao.findAllByTitle( title ));
        return publicationDtos;
    }*/
}
