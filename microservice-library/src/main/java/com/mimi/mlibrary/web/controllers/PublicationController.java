package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.dao.AuthorDao;
import com.mimi.mlibrary.model.publication.Author;
import com.mimi.mlibrary.model.publication.Publication;
import com.mimi.mlibrary.service.PublicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PublicationController {
    private PublicationService publicationService;
    private AuthorDao authorDao;

    public PublicationController(PublicationService publicationService, AuthorDao authorDao ){
        this.publicationService = publicationService;
        this.authorDao = authorDao;
    }

    @GetMapping( value = "/Publication" )
    public List<Publication> getAllPublications(@RequestParam(value="title", required= false) String title) {
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

    @GetMapping( value ="/Publication/title/{title}")
    public List<Publication> findPublicationByTitle(@PathVariable String title ) {
        return publicationService.findAllByTitle( title );
    }

    @GetMapping( value = "/Author" )
    public List<Author> findAll() {
        return authorDao.findAll();
    }
}

