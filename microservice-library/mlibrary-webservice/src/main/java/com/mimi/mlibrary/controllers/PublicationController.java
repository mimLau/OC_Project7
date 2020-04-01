package com.mimi.mlibrary.controllers;

import com.mimi.mlibrary.model.dto.publication.*;
import com.mimi.mlibrary.service.contract.PublicationService;
import com.mimi.mlibrary.exceptions.ResourceNotFoundException;
import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Publications")
public class PublicationController {

    private PublicationService publicationService;

    public PublicationController(PublicationService publicationService){
        this.publicationService = publicationService;
    }


    /****************
     * Books
     * **************/

    @GetMapping( value = "/Books" )
    public List<BookDto> getAllBooks() {
        List<BookDto> bookDtos = publicationService.findAllBooks();
        if( bookDtos.isEmpty() ) throw new ResourceNotFoundException(  "La liste des livres est vide." );

        return bookDtos;
    }


    /****************
     * Newspapers
     * **************/

    @GetMapping( value = "/Newspapers" )
    public List<NewspaperDto> getAllNewspaper() {
        List<NewspaperDto> newspaperDtos = publicationService.findAllNewspapers();
        if( newspaperDtos.isEmpty() ) throw new ResourceNotFoundException(  "La liste des journaux est vide." );

        return newspaperDtos;
    }

    @GetMapping( value = "/Newspapers", params = "date")
    public List<NewspaperDto> getAllNewspapersByDate( @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date ) {

        //LocalDate localDate = LocalDate.parse( date, DateTimeFormat.forPattern("yyyy/MM/dd"));
        List<NewspaperDto> newspaperDtos = publicationService.findAllNewspapersByDate( date );
        if( newspaperDtos.isEmpty() ) throw new ResourceNotFoundException(  "Aucun journal ne correspond à cette date." );

        return newspaperDtos;
    }


    /****************
     * Reviews
     * **************/

    @GetMapping( value = "/Reviews")
    public List<ReviewDto> getAllReview() {
        List<ReviewDto> reviewDtos = publicationService.findAllReviews();
        if( reviewDtos.isEmpty() ) throw new ResourceNotFoundException(  "La liste des revues est vide." );

        return reviewDtos;
    }

    @GetMapping( value = "/Reviews", params = "date")
    public List<ReviewDto> getAllReviewsByDate( @RequestParam LocalDate date ) {
        List<ReviewDto> reviewDtos = publicationService.findAllReviewsByDate( date );
        if( reviewDtos.isEmpty() ) throw new ResourceNotFoundException(  "Aucune revue ne correspond à cette date." );

        return reviewDtos ;
    }


    /****************
     * Publications
     * **************/

    @GetMapping( params = "id" )
    public PublicationDto getPublicationsById(@RequestParam int id ) {
        PublicationDto publicationDto = publicationService.findPublicationById( id );
        if( publicationDto == null ) throw new ResourceNotFoundException( "Il n'y a pas d'ouvrage qui correspond à cette date." );

        return publicationDto;
    }

    @GetMapping
    public List<PublicationDto> getAllPublications() {
        List<PublicationDto> publicationDtos = publicationService.findAllPublications();
        if( publicationDtos.isEmpty() ) throw new ResourceNotFoundException( "Il n'y a pas d'ouvrage dans la base de données." );

        return publicationDtos ;
    }

    @GetMapping( params = "title")
    public List<PublicationDto> getAllPublicationsByTitle( @RequestParam String title ) {
        List<PublicationDto> publicationDtos = publicationService.findAllByTitle( title );
        if( publicationDtos.isEmpty() ) throw new ResourceNotFoundException( "Il n'y a pas d'ouvrage qui correspond à ce titre." );

        return publicationDtos;
    }

    @GetMapping( params = "author" )
    public List<PublicationDto> getAllByAuthor( @RequestParam String author ) {
        List<PublicationDto> publicationDtos =  publicationService.findAllByAuthor( author );
        if( publicationDtos.isEmpty() ) throw new ResourceNotFoundException( "Il n'y a pas de livre qui corresponde à cet auteur." );

        return publicationDtos;
    }

    @GetMapping( value = "/author", params = "id")
    public List<PublicationDto> getAllByAuthorId( @RequestParam int id ) {
        List<PublicationDto> publicationDtos =  publicationService.findAllByAuthorId( id );
        if( publicationDtos.isEmpty() ) throw new ResourceNotFoundException(  "Il n'y a pas de livre qui corresponde à cet auteur." );

        return publicationDtos;
    }

}

