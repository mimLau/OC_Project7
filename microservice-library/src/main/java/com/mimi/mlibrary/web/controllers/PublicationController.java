package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.dao.AuthorDao;
import com.mimi.mlibrary.dao.PublicationDao;
import com.mimi.mlibrary.model.publications.Author;
import com.mimi.mlibrary.model.publications.Publication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PublicationController {
    private PublicationDao publicationDao;
    private AuthorDao authorDao;

    public PublicationController(PublicationDao publicationDao, AuthorDao authorDao ){
        this.publicationDao = publicationDao;
        this.authorDao = authorDao;
    }

    @GetMapping( value = "/Publication" )
    public List<Publication> getAllPublications(@RequestParam(value="title", required= false) String title) {
        return publicationDao.findAll();
    }


    @GetMapping( value = "/Publication/{id}" )
    public Optional<Publication> getPublicationById(@PathVariable int id ) {
        return publicationDao.findById( id );
    }

    @GetMapping( value = "/Authors" )
    public List<Author> getAllAuthors() {
        return authorDao.findAll();
    }

    @GetMapping(value= "/Publications/{isbn}" )
    public Publication getPublicationByIsbn(@PathVariable String isbn ) {
       return publicationDao.searchPublicationByIsbn( isbn );
    }

    @GetMapping( value ="/Publications/getByAuthorName/{name}")
    public List<Publication> getPublicationByAuthorName(@PathVariable String name ) {
        return publicationDao.searchPublicationsByAuthorName( name );
    }

    @GetMapping( value ="/Works/getByTitle/{title}")
    public List<Publication> getPublicationByTitle(@PathVariable String title ) {
        return publicationDao.searchPublicationsByTitle( title );
    }
}

