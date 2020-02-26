package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.source.publication.Newspaper;
import com.mimi.mlibrary.service.publication.NewspaperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class NewspaperController {

    private NewspaperService newspaperService;

    public NewspaperController(NewspaperService newspaperService) {
        this.newspaperService = newspaperService;
    }

    @GetMapping( value = "/Newspapers/{name}" )
    public List<Newspaper> findAllByName(@PathVariable String name ){
        return newspaperService.findAllByName( name );
    }
}


