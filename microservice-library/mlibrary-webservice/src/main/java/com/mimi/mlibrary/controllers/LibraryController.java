package com.mimi.mlibrary.controllers;

import com.mimi.mlibrary.exceptions.ResourceNotFoundException;
import com.mimi.mlibrary.model.dto.publication.LibraryDto;
import com.mimi.mlibrary.service.contract.PublicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {

    private PublicationService publicationService;

    public LibraryController( PublicationService publicationService ) {
        this.publicationService = publicationService;
    }

    @GetMapping( value = "/Libraries" )
    public List<LibraryDto> getAllLibraries() {
        List<LibraryDto> libraryDtos = publicationService.findAllLibraries();
        if( libraryDtos.isEmpty() ) throw new ResourceNotFoundException(  "La liste des librairies est vide." );

        return libraryDtos;
    }
}
