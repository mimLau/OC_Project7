package com.mimi.mlibrary.controllers;

import com.mimi.mlibrary.exceptions.ResourceNotFoundException;
import com.mimi.mlibrary.model.dto.publication.AuthorDto;
import com.mimi.mlibrary.service.contract.PublicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
public class AuthorController {

    private PublicationService publicationService;

    public AuthorController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping( value = "/Authors" )
    public List<AuthorDto> getAllAuthor() {
        List<AuthorDto> authorDtos =  publicationService.findAllAuthor();
        if( authorDtos.isEmpty() ) throw new ResourceNotFoundException(  "Il n'y a pas d'auteur qui correspond à votre recherche." );

        return authorDtos ;
    }

    @PostMapping( value = "/Authors" )
    public ResponseEntity<String> addAuthor(@RequestBody AuthorDto authorDto ) {

        //org.hibernate.exception.ConstraintViolationException: could not execute statemen
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

}
