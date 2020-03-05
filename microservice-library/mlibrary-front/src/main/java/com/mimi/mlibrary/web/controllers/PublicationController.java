package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.dest.publication.*;
import com.mimi.mlibrary.model.source.publication.*;
import com.mimi.mlibrary.service.PublicationService;
import com.mimi.mlibrary.web.exceptions.ResourceNotFoundException;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
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
    public List<NewspaperDto> getAllNewspapersByDate( @RequestParam String date ) {

        LocalDate localDate = LocalDate.parse( date, DateTimeFormat.forPattern("yyyy/MM/dd"));
        List<NewspaperDto> newspaperDtos = publicationService.findAllNewspapersByDate( localDate );
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

    @GetMapping( value = "/Publications", params = "id" )
    public PublicationDto getPublicationsById(@RequestParam int id ) {
        PublicationDto publicationDto = publicationService.findPublicationById( id );
        if( publicationDto == null ) throw new ResourceNotFoundException( "Il n'y a pas d'ouvrage qui correspond à cette date." );

        return publicationDto;
    }

    @GetMapping( value = "/Publications")
    public List<PublicationDto> getAllPublications() {
        List<PublicationDto> publicationDtos = publicationService.findAllPublications();
        if( publicationDtos.isEmpty() ) throw new ResourceNotFoundException( "Il n'y a pas d'ouvrage dans la base de données." );

        return publicationDtos ;
    }

    @GetMapping( value = "/Publications", params = "title")
    public List<PublicationDto> getAllPublicationsByTitle( @RequestParam String title ) {
        List<PublicationDto> publicationDtos = publicationService.findAllByTitle( title );
        if( publicationDtos.isEmpty() ) throw new ResourceNotFoundException( "Il n'y a pas d'ouvrage qui correspond à ce titre." );

        return publicationDtos;
    }

    @GetMapping( value = "/Publications", params = "author" )
    public List<PublicationDto> getAllByAuthor( @RequestParam String author ) {
        List<PublicationDto> publicationDtos =  publicationService.findAllByAuthor( author );
        if( publicationDtos.isEmpty() ) throw new ResourceNotFoundException( "Il n'y a pas de livre qui corresponde à cet auteur." );

        return publicationDtos;
    }


    @GetMapping( value = "/Publications/auth", params = "id")
    public List<PublicationDto> getAllByAuthorId( @RequestParam int id ) {
        List<PublicationDto> publicationDtos =  publicationService.findAllByAuthorId( id );
        if( publicationDtos.isEmpty() ) throw new ResourceNotFoundException(  "Il n'y a pas de livre qui corresponde à cet auteur." );

        return publicationDtos;
    }



    /****************
     * Authors
     * **************/

    @GetMapping( value = "/Authors" )
    public List<AuthorDto> getAllAuthor() {
        List<AuthorDto> authorDtos =  publicationService.findAllAuthor();
        if( authorDtos.isEmpty() ) throw new ResourceNotFoundException(  "Il n'y a pas d'auteur qui correspond à votre recherche." );

        return authorDtos ;
    }

    @PostMapping( value = "/Authors" )
    public ResponseEntity<String> addAuthor( @RequestBody AuthorDto authorDto ) {
        AuthorDto addedAuthorDto = publicationService.saveAuthor( authorDto );
        if( addedAuthorDto == null)
            //return ResponseEntity.noContent().build();
            return new ResponseEntity<>("La ressource envoyée est vide.", HttpStatus.NO_CONTENT);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedAuthorDto.getId() ).toUri();
        return ResponseEntity.created( location ).build();
    }

    @DeleteMapping( value = "/Authors", params = "id")
    public @ResponseBody ResponseEntity<String> deleteAuthorById( @RequestParam int id ) {
        publicationService.deleteAuthorById( id );

        return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
    }


    /****************
     * Copies
     * **************/

    @GetMapping( value = "/Copies")
    public List<CopyDto> getAllCopies() {
        List<CopyDto> copyDtos =  publicationService.findAllCopy();
        if( copyDtos.isEmpty() ) throw new ResourceNotFoundException(  "Il n'y a aucun exemplaire d'ouvrage dans la base de données." );

        return copyDtos;
    }

    @GetMapping( value = "/Copies", params = "id")
    public CopyDto getCoyById( @RequestParam int id ) {
        CopyDto copyDto =  publicationService.findCopyById( id ) ;
        if( copyDto == null ) throw new ResourceNotFoundException(  "Aucun exemplaire ne correspond à cette id." );

        return copyDto;
    }

    @GetMapping( value = "/Copies/delay" )
    public List<CopyDto> getAllByDelay(  ) {
        List<CopyDto> copyDtos =  publicationService.findAllCopyByDelay();
        if( copyDtos.isEmpty() ) throw new ResourceNotFoundException(  "Il n'y a aucun exemplaire dont la date de retour est passée." );

        return copyDtos;
    }

    @GetMapping( value = "/Copies-pub", params = "id" )
    public List<CopyDto> getAllCopyPublicationId( @RequestParam int id  ) {
        List<CopyDto> copyDtos =  publicationService.findAllCopyByPublicationId( id );
        if( copyDtos.isEmpty() ) throw new ResourceNotFoundException(  "Il n'y a aucun exemplaire qui correspond à cette ouvrage." );

        return copyDtos;
    }

}

