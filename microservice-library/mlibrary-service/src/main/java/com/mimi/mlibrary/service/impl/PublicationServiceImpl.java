package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.repository.publication.AuthorRepository;
import com.mimi.mlibrary.repository.publication.CopyRepository;
import com.mimi.mlibrary.repository.publication.PublicationRepository;
import com.mimi.mlibrary.mapper.publication.*;
import com.mimi.mlibrary.model.dto.publication.*;
import com.mimi.mlibrary.service.contract.PublicationService;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationRepository publicationRepository;
    private AuthorRepository authorRepository;
    private CopyRepository copyRepository;


    PublicationServiceImpl(PublicationRepository publicationRepository, AuthorRepository authorRepository, CopyRepository copyRepository) {
        this.publicationRepository = publicationRepository;
        this.authorRepository = authorRepository;
        this.copyRepository = copyRepository;
    }



    /****************
     * Books
     * **************/

    @Override
    public List<BookDto> findAllBooks() {
        return BookMapper.INSTANCE.toDtoList( publicationRepository.findAllBooks() );
    }


    /****************
     * Newspapers
     * **************/

    @Override
    public List<NewspaperDto> findAllNewspapers() {
        return NewspaperMapper.INSTANCE.toDtoList( publicationRepository.findAllNewspapers() );
    }

    @Override
    public List<NewspaperDto> findAllNewspapersByDate( LocalDate date ) {
        //TODO convert date or something like this
        return NewspaperMapper.INSTANCE.toDtoList( publicationRepository.findAllNewspaperByDate( date ) );
    }



    /****************
     * Reviews
     * **************/

    @Override
    public List<ReviewDto> findAllReviews() {
        return ReviewMapper.INSTANCE.toDtoList( publicationRepository.findAllReviews());
    }

    @Override
    public List<ReviewDto> findAllReviewsByDate( LocalDate date ) {
        return ReviewMapper.INSTANCE.toDtoList( publicationRepository.findAllReviewsByDate( date ) );
    }



    /****************
     * Publications
     * **************/


    @Override
    public PublicationDto findPublicationById( int id ) {
        return PublicationMapper.INSTANCE.toDto( publicationRepository.findPublicationById( id ).orElse( null ));
    }

    @Override
    public List<PublicationDto> findAllPublications() {
        return  PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllPublications());
    }

    @Override
    public List<PublicationDto> findAllByTitle( String title ) {
       return  PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllByTitle( title ));
    }

    @Override
    public List<PublicationDto> findAllByAuthor( String name ) {
        return PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllByAuthor( name ) );
    }

    @Override
    public List<PublicationDto> findAllByAuthorId( int id ) {
        return PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllByAuthorId( id ) );
    }

    @Override
    public PublicationDto findByIsbn( String idNb ) {
        return PublicationMapper.INSTANCE.toDto( publicationRepository.findAllByIsbn( idNb).orElse( null ));
    }



    /****************
     * Authors
     * **************/

   @Override
    public List<AuthorDto> findAllAuthor() {
       return AuthorMapper.INSTANCE.toDtoList( authorRepository.findAll() );
    }

    @Override
    public AuthorDto saveAuthor( AuthorDto authorDto ) {

       Optional.of( AuthorMapper.INSTANCE.toEntity( authorDto ) ).ifPresent( author -> authorRepository.save( author ) );
       //authorDao.save( AuthorMapper.INSTANCE.dtoToAuth( authorDto ));
       return authorDto;
    }

    @Override
    public void deleteAuthorById( int id ) {
         authorRepository.deleteAuthorById( id );
    }



    /****************
     * Copies
     * **************/

    @Override
    public List<CopyDto> findAllCopy() {
        return CopyMapper.INSTANCE.toDtoList( copyRepository.findAll() );
    }

    @Override
    public List<CopyDto> findAllCopyByPublicationId( int publicationId ) {
        return CopyMapper.INSTANCE.toDtoList( copyRepository.findAllCopyByPublicationId( publicationId ) );
    }

    @Override
    public List<CopyDto> findAllCopyByDelay( ) {
        LocalDate localDate = new LocalDate();
        return CopyMapper.INSTANCE.toDtoList( copyRepository.findAllByDelay( localDate ) );
    }

    @Override
    public void updateCopyReturnDateById( LocalDate newDate, int id) {
        copyRepository.updateCopyReturnDateById( newDate, id );
    }


    @Override
    public CopyDto findCopyById( int id ) {
        return CopyMapper.INSTANCE.toDto( copyRepository.findCopyById( id ).orElse(null) );
    }

}
