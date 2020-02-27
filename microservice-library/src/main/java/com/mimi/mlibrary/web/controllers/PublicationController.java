package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.source.publication.*;
import com.mimi.mlibrary.service.PublicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublicationController {

    private PublicationService publicationService;

    public PublicationController(PublicationService publicationService){
        this.publicationService = publicationService;
    }

    //Author
    @GetMapping( value = "/Authors" )
    public List<Author> getAllAuthor() {
        return publicationService.findAllAuthor();
    }

    //Book
    @GetMapping( value = "/Books" )
    public List<Book> getAllBooks() {
        return publicationService.findAllBook();
    }

    @GetMapping( value = "/Books", params = "name" )
    public List<Book> findAllByAuthor( @RequestParam String name ) {
        return publicationService.findAllBookByAuthor( name );
    }

    @GetMapping( value = "/Books", params = "title")
    public List<Book> findAllByTitle( @RequestParam String title ) {
        return publicationService.findAllBookByTitle( title );
    }

    @GetMapping( value = "/Books/AuthorId", params = "id")
    public List<Book> findAllByAuthorId( @RequestParam int id ) {
        return publicationService.findAllBookByAuthorId( id );
    }


    //Copy

    @GetMapping( value = "/Copies" )
    public List<Copy> getAllCopies() {
        return publicationService.findAllCopy();
    }


    @GetMapping( value = "/Copies/delay" )
    public List<Copy> findAllByDelay(  ) {
        return publicationService.findAllCopyByDelay();
    }


    //Newspaper

    @GetMapping( value = "/Newspapers")
    public List<Newspaper> getAllNewspaper(){
        return publicationService.findAllNewspaper();
    }

    @GetMapping( value = "/Newspapers", params = "name")
    public List<Newspaper> findAllNewspaperByName( @RequestParam String name ){
        return publicationService.findAllNewspaperByName( name );
    }

    @GetMapping( value = "/Newspapers", params = "date")
    public List<Newspaper> findAllNewspapersByDate( @RequestParam String date ){
        return publicationService.findAllNewspaperByDate( date );
    }


    //Review

    @GetMapping( value = "/Reviews")
    public List<Review> findAllReview(){
        return publicationService.findAllReview();
    }

    @GetMapping( value = "/Reviews", params = "name")
    public List<Review> findAllReviewByName( @RequestParam String name ){
        return publicationService.findAllReviewByName( name );
    }

    @GetMapping( value = "/Reviews", params = "date")
    public List<Review> findAllReviewsByDate( @RequestParam String date ){
        return publicationService.findAllReviewByDate( date );
    }
















    /*@GetMapping( value = "/Book")
    public List<BookDto> getAllBooks() {
        return publicationService.findAllBooks();
    }

    @GetMapping( value = "/Publication" )
    public List<PublicationDto> getAllPublications(@RequestParam(value="title", required= false) String title) {
        if( title == null )
            return publicationService.findAll();
        else
            return publicationService.findAllByTitle(title);
    }

    @GetMapping( value = "/Publication/{id}" )
    public Optional<Publication> getPublicationById(@PathVariable int id ) {
        return publicationService.findById( id );
    }

    @GetMapping(value= "/Publication/isbn/{isbn}" )
    public Publication getPublicationByIsbn(@PathVariable String isbn ) {
       return publicationService.findByIsbn( isbn );
    }

    @GetMapping( value ="/Publication/authorName/{name}")
    public List<Publication> getPublicationByAuthor(@PathVariable String name ) {
        return publicationService.findAllByAuthor( name );
    }

    /*@GetMapping( value ="/Publication/title/{title}")
    public List<Publication> findPublicationByTitle(@PathVariable String title ) {
        return publicationService.findAllByTitle( title );
    }*/

    /*@GetMapping( value = "/Author" )
    public List<Author> findAll() {
        return authorDao.findAll();
    }*/
}

