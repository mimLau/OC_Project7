package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.model.entity.publication.Category;
import com.mimi.mlibrary.model.entity.publication.Criteria;
import com.mimi.mlibrary.model.entity.publication.Publication;
import com.mimi.mlibrary.specifications.PublicationSpecification;
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

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationRepository publicationRepository;
    private AuthorRepository authorRepository;
    private CopyRepository copyRepository;
    private LibraryRepository libraryRepository;


    PublicationServiceImpl( PublicationRepository publicationRepository, AuthorRepository authorRepository, CopyRepository copyRepository, LibraryRepository libraryRepository) {
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
    public List<PublicationDto> findAllByCriteria( String author, String title, String category, String editor, int libId ) {

        Criteria criteria = new Criteria();

        if( category != null ) {
            switch (category) {

                case "Livres":
                    criteria.setCategory(Category.BOOK);
                    break;
                case "Journaux":
                    criteria.setCategory(Category.NEWSPAPER);
                    break;
                case "Revues":
                    criteria.setCategory(Category.REVIEW);
                    break;
            }
        }

        criteria.setAuthorName( author );
        criteria.setEditorName( editor );
        criteria.setTitle( title );
        criteria.setLibId( libId );
        Specification<Publication> pubSpec = new PublicationSpecification(  criteria );

        return PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAll( pubSpec ) );

    }

    /*********
     * Books *
     * *******/

    /*@Override
    public List<BookDto> findAllBooks(  ) {
        //Pageable bb = PageRequest.of(0, 4, Sort.by("title"));
        return  BookMapper.INSTANCE.toDtoList(publicationRepository.findAllBooks( ));

    }*/


    /****************
     * Publications *
     * **************/


    @Override
    public PublicationDto findPublicationById( int id ) {
        return PublicationMapper.INSTANCE.toDto( publicationRepository.findPublicationById( id ).orElse( null ));
    }

    @Override
    public List<PublicationDto> findAllPublications() {
        return  PublicationMapper.INSTANCE.toDtoList( publicationRepository.findAllPublications());
    }


    /***********
     * Authors *
     * *********/

   @Override
    public List<AuthorDto> findAllAuthor() {
       return AuthorMapper.INSTANCE.toDtoList( authorRepository.findAll() );
    }

    @Override
    public AuthorDto saveAuthor( AuthorDto authorDto ) {

       Optional.of( AuthorMapper.INSTANCE.toEntity( authorDto ) ).ifPresent( author -> authorRepository.save( author ) );
       return authorDto;
    }

    @Override
    public void deleteAuthorById( int id ) {
         authorRepository.deleteAuthorById( id );
    }



    /**********
     * Copies *
     * ********/

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
    public CopyDto findCopyById( int id ) {
        return CopyMapper.INSTANCE.toDto( copyRepository.findCopyById( id ).orElse(null) );
    }


    @Override
    public List<CopyDto>  findAvailableCopiesByLibrary( int libId ) {
        return CopyMapper.INSTANCE.toDtoList( copyRepository.countAllCopyByPublicationIdAndDistinctLib( libId) );
    }



}
