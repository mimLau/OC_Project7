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
        if( title == null )
            return publicationDao.findAll();
        else
            return publicationDao.findAllByTitle(title);
    }


    @GetMapping( value = "/Publication/{id}" )
    public Optional<Publication> getPublicationById(@PathVariable int id ) {
        return publicationDao.findById( id );
    }

    @GetMapping(value= "/Publication/isbn/{isbn}" )
    public Publication getPublicationByIsbn(@PathVariable String isbn ) {
       return publicationDao.findByIsbn( isbn );
    }

    @GetMapping( value ="/Publication/authorName/{name}")
    public List<Publication> getPublicationByAuthor(@PathVariable String name ) {
        return publicationDao.findAllByAuthor( name );
    }

    @GetMapping( value ="/Publication/title/{title}")
    public List<Publication> findPublicationByTitle(@PathVariable String title ) {
        return publicationDao.findAllByTitle( title );
    }

    @GetMapping( value = "/Author" )
    public List<Author> findAll() {
        return authorDao.findAll();
    }
}

