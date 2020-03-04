package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.dest.publication.*;
import com.mimi.mlibrary.model.source.publication.*;
import com.mimi.mlibrary.service.PublicationService;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
        return publicationService.findAllBooks();
    }


    /****************
     * Newspapers
     * **************/

    @GetMapping( value = "/Newspapers")
    public List<NewspaperDto> getAllNewspaper(){
        return publicationService.findAllNewspapers();
    }

    @GetMapping( value = "/Newspapers", params = "date")
    public List<NewspaperDto> getAllNewspapersByDate( @RequestParam String date ){

        LocalDate d = new LocalDate();

        LocalDate localDate = LocalDate.parse(date,
                DateTimeFormat.forPattern("yyyy/MM/dd"));

        return publicationService.findAllNewspapersByDate( localDate );
    }


    /****************
     * Reviews
     * **************/

    @GetMapping( value = "/Reviews")
    public List<ReviewDto> getAllReview(){
        return publicationService.findAllReviews();
    }

    @GetMapping( value = "/Reviews", params = "date")
    public List<ReviewDto> getAllReviewsByDate( @RequestParam LocalDate date ){
        return publicationService.findAllReviewsByDate( date );
    }


    /****************
     * Publications
     * **************/

    @GetMapping( value = "/Publications", params = "id" )
    public PublicationDto getPublicationsById(@RequestParam int id ) {
        return publicationService.findPublicationById( id );
    }

    @GetMapping( value = "/Publications")
    public List<PublicationDto> getAllPublications(  ) {
        return publicationService.findAllPublications();
    }

    @GetMapping( value = "/Publications", params = "title")
    public List<PublicationDto> getAllPublicationsByTitle( @RequestParam String title ) {
        return publicationService.findAllByTitle( title );
    }


    @GetMapping( value = "/Publications", params = "author" )
    public List<PublicationDto> getAllByAuthor( @RequestParam String author ) {
        return publicationService.findAllByAuthor( author );
    }


    @GetMapping( value = "/Publications/auth", params = "id")
    public List<PublicationDto> getAllByAuthorId( @RequestParam int id ) {
        return publicationService.findAllByAuthorId( id );
    }



    /****************
     * Authors
     * **************/

    @GetMapping( value = "/Authors" )
    public List<AuthorDto> getAllAuthor() {
        return publicationService.findAllAuthor();
    }

    @PostMapping( value = "/Authors" )
    public ResponseEntity<Void> addAuthor( @RequestBody Author author ) {
        AuthorDto addedBorrowing = publicationService.saveAuthor( author );
        if( addedBorrowing == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand( addedBorrowing.getId() ).toUri();
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
        return publicationService.findAllCopy();
    }

    @GetMapping( value = "/Copies", params = "id")
    public CopyDto getCoyById( @RequestParam int id ) {
        return publicationService.findCopyById( id );
    }

    @GetMapping( value = "/Copies/delay" )
    public List<CopyDto> getAllByDelay(  ) {
        return publicationService.findAllCopyByDelay();
    }

    @GetMapping( value = "/Copies-pub", params = "id" )
    public List<CopyDto> getAllCopyPublicationId(  @RequestParam int id  ) {
        return publicationService.findAllCopyByPublicationId( id );
    }

}

