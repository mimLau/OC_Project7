package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.dao.AuthorDao;
import com.mimi.mlibrary.dao.WorkDao;
import com.mimi.mlibrary.model.publications.Author;
import com.mimi.mlibrary.model.publications.Publication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class WorkController {
    private WorkDao workDao;
    private AuthorDao authorDao;

    public WorkController( WorkDao workDao, AuthorDao authorDao ){
        this.workDao = workDao;
        this.authorDao = authorDao;
    }

    @GetMapping( value = "/Work" )
    public List<Publication> getAllworks(@RequestParam(value="title", required= false) String title) {
        return workDao.findAll();
    }


    @GetMapping( value = "/Work/{id}" )
    public Optional<Publication> getWorkById(@PathVariable int id ) {
        return workDao.findById( id );
    }

    @GetMapping( value = "/Authors" )
    public List<Author> getAllAuthors() {
        return authorDao.findAll();
    }

    @GetMapping(value= "/Works/{isbn}" )
    public Publication getWorkByIsbn(@PathVariable String isbn ) {
       return workDao.searchWorkByIsbn( isbn );
    }

    @GetMapping( value ="/Works/getByAuthorName/{name}")
    public List<Publication> getWorkByAuthorName(@PathVariable String name ) {
        return workDao.searchWorksByAuthorName( name );
    }

    @GetMapping( value ="/Works/getByTitle/{title}")
    public List<Publication> getWorkByTitle(@PathVariable String title ) {
        return workDao.searchWorksByTitle( title );
    }
}

