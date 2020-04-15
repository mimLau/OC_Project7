package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.model.entity.publication.Category;
import com.mimi.mlibrary.model.entity.publication.Criteria;
import com.mimi.mlibrary.model.entity.publication.Publication;
import com.mimi.mlibrary.model.entity.publication.PublicationSpecification;
import com.mimi.mlibrary.repository.publication.AuthorRepository;
import com.mimi.mlibrary.repository.publication.CopyRepository;
import com.mimi.mlibrary.repository.publication.LibraryRepository;
import com.mimi.mlibrary.repository.publication.PublicationRepository;
import com.mimi.mlibrary.mapper.publication.*;
import com.mimi.mlibrary.model.dto.publication.*;
import com.mimi.mlibrary.service.contract.PublicationService;
import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublicationServiceImpl implements PublicationService {

    private static final String TITLE_ATT = "Titre";
    private static final String EXACT_TITLE_ATT = "Titre exact";
    private static final String AUTHOR_ATT = "Auteur";

    private PublicationRepository publicationRepository;
    private AuthorRepository authorRepository;
    private CopyRepository copyRepository;
    private LibraryRepository libraryRepository;


    PublicationServiceImpl(PublicationRepository publicationRepository, AuthorRepository authorRepository, CopyRepository copyRepository, LibraryRepository libraryRepository) {
        this.publicationRepository = publicationRepository;
        this.authorRepository = authorRepository;
        this.copyRepository = copyRepository;
        this.libraryRepository = libraryRepository;
    }


    @Override
    public List<LibraryDto> findAllLibraries() {
        return LibraryMapper.INSTANCE.toDtoList( libraryRepository.findAllLibraries() );
    }

    @Override
    public List<PublicationDto> findAllByCriteria(String author, String title, Category category, LocalDate date, String editor, int libId ) {
        Criteria criteria = new Criteria();
        criteria.setAuthorName( author );
        criteria.setCategory( category );
        criteria.setEditorName( editor );
        criteria.setTitle( title );
        criteria.setPubDate( date );
        criteria.setLibId( libId );
        Specification<Publication> pubSpec = new PublicationSpecification(  criteria );

        return PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAll( pubSpec ) );

    }

    /****************
     * Books
     * **************/

    /*@Override
    public List<BookDto> findAllBooks(  ) {
        //Pageable bb = PageRequest.of(0, 4, Sort.by("title"));
        return  BookMapper.INSTANCE.toDtoList(publicationRepository.findAllBooks( ));

    }*/

    /****************
     * Newspapers
     * **************/

   /* @Override
    public List<NewspaperDto> findAllNewspapers() {
        return NewspaperMapper.INSTANCE.toDtoList( publicationRepository.findAllNewspapers() );
    }

    @Override
    public List<NewspaperDto> findAllNewspapersByDate( LocalDate date ) {
        //TODO convert date or something like this
        return NewspaperMapper.INSTANCE.toDtoList( publicationRepository.findAllNewspaperByDate( date ) );
    }*/



    /****************
     * Reviews
     * **************/

    /*@Override
    public List<ReviewDto> findAllReviews() {
        return ReviewMapper.INSTANCE.toDtoList( publicationRepository.findAllReviews());
    }

    @Override
    public List<ReviewDto> findAllReviewsByDate( LocalDate date ) {
        return ReviewMapper.INSTANCE.toDtoList( publicationRepository.findAllReviewsByDate( date ) );
    }*/


    /****************
     * Publications
     * **************/


    @Override
    public List<PublicationDto> findPublicationByCriteria( String criteria, String value, int libId ) {
        List<PublicationDto> publicationDtos = new ArrayList<>();
        if ( criteria.equals( EXACT_TITLE_ATT ))
            if( libId == 0)
                 publicationDtos = PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllByExactTitle( value ));
            else publicationDtos = PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllByExactTitle( value, libId ));

        else if ( criteria.equals( TITLE_ATT ))
            if( libId == 0)
                 publicationDtos = PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllByTitle( value));
            else publicationDtos = PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllByTitle( value, libId ));

        else if ( criteria.equals( AUTHOR_ATT ))
            if ( libId==0 )
                 publicationDtos = this.findAllByAuthor( value );
            else publicationDtos = this.findAllByAuthor( value, libId );

        return publicationDtos;
    }

    @Override
    public PublicationDto findPublicationById( int id ) {
        return PublicationMapper.INSTANCE.toDto( publicationRepository.findPublicationById( id ).orElse( null ));
    }

    @Override
    public List<PublicationDto> findAllPublications() {
        return  PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllPublications());
    }

    @Override
    public List<PublicationDto> findAllByTitle( String title, int libId ) {
       return  PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllByTitle( title, libId ));
    }

    @Override
    public List<PublicationDto> findAllByExactTitle( String title, int libId ) {
        return  PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllByExactTitle( title, libId ));
    }

    @Override
    public List<PublicationDto> findAllByAuthor( String authorName, int libId ) {
        List <String> names = Arrays.stream( authorName.split(" ")).map(String:: new).collect(Collectors.toList() );
        List<PublicationDto> publicationDtos = null;

        if( names.size() > 1) {
            for(String name : names ){
                publicationDtos = PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllByAuthor( name, libId ));

                if(publicationDtos.isEmpty())
                    return publicationDtos;
            }

        } else
            publicationDtos = PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllByAuthor( names.get(0), libId ));


        return publicationDtos;
    }

    @Override
    public List<PublicationDto> findAllByAuthor( String authorName ) {
        List <String> names = Arrays.stream( authorName.split(" ")).map(String:: new).collect(Collectors.toList() );
        List<PublicationDto> publicationDtos = null;

        if( names.size() > 1) {
            for(String name : names ){
                publicationDtos = PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllByAuthor( name ));

                if(publicationDtos.isEmpty())
                    return publicationDtos;
            }

        } else
            publicationDtos = PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllByAuthor( names.get(0) ));


        return publicationDtos;
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
        LocalDate localDate = LocalDate.now();
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


    @Override
    public List<CopyDto>  findAvailableCopiesByLibrary( int libId ) {
        return CopyMapper.INSTANCE.toDtoList( copyRepository.countAllCopyByPublicationIdAndDistinctLib( libId) );
    }



}
