package com.mimi.mlibrary.controllers;

import com.mimi.mlibrary.exceptions.ResourceNotFoundException;
import com.mimi.mlibrary.model.dto.publication.CopyDto;
import com.mimi.mlibrary.service.contract.PublicationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CopyController {

    private PublicationService publicationService;

    public CopyController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping( value = "/Copies/{id}" )
    public ResponseEntity<CopyDto> getCoyById( @PathVariable int id ) {

        CopyDto copyDto =  publicationService.findCopyById( id ) ;

        if( copyDto == null )
            return new ResponseEntity<>( null, HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>( copyDto, HttpStatus.FOUND );
    }


    @GetMapping( value = "/Copies/delay" )
    public List<CopyDto> getAllByDelay(  ) {
        List<CopyDto> copyDtos =  publicationService.findAllCopyByDelay();
        if( copyDtos.isEmpty() ) throw new ResourceNotFoundException(  "Il n'y a aucun exemplaire dont la date de retour est passée." );

        return copyDtos;
    }

    @GetMapping( value = "/Copies/publication/{id}" )
    public List<CopyDto> getAllCopyByPublicationId( @PathVariable int id  ) {
        List<CopyDto> copyDtos =  publicationService.findAllCopyByPublicationId( id );
        if( copyDtos.isEmpty() ) throw new ResourceNotFoundException(  "Il n'y a aucun exemplaire qui correspond à cette ouvrage." );

        return copyDtos;
    }

    @GetMapping( value = "/Copies/publication", params = "pubId")
    public List<CopyDto> getAvailableCopiesByLibrary( @RequestParam int pubId  ) {
        List<CopyDto> copyDtos =  publicationService.findAvailableCopiesByLibrary( pubId );
        if( copyDtos.isEmpty() ) throw new ResourceNotFoundException(  "Il n'y a pas d'exemplaires de disponible de l'ouvrage recherché." );

        return copyDtos;
    }


}
