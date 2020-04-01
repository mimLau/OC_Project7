package com.mimi.mlibrary.controllers;

import com.mimi.mlibrary.exceptions.ResourceNotFoundException;
import com.mimi.mlibrary.model.dto.publication.CopyDto;
import com.mimi.mlibrary.service.contract.PublicationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class CopyController {

    final static Logger logger  = LogManager.getLogger(PublicationController.class);
    private PublicationService publicationService;

    public CopyController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping( value = "/Copies")
    public List<CopyDto> getAllCopies() {
        List<CopyDto> copyDtos =  publicationService.findAllCopy();
        if( copyDtos.isEmpty() ) throw new ResourceNotFoundException(  "Il n'y a aucun exemplaire d'ouvrage dans la base de données." );

        return copyDtos;
    }

   /*@GetMapping( value = "/Copies", params = "id")
    public CopyDto getCoyById( @RequestParam int id ) {
        CopyDto copyDto =  publicationService.findCopyById( id ) ;
        if( copyDto == null )
            throw new ResourceNotFoundException(  "Aucun exemplaire ne correspond à cet id." );

        return copyDto;
    }*/

    @GetMapping( value = "/Copies", params = "id")
    public ResponseEntity<CopyDto> getCoyById(@RequestParam int id, HttpServletResponse response ) {

        logger.info(" Recherche de l'exemplaire avec l'id: " + id );
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

    @GetMapping( value = "/Copies/publication", params = "id" )
    public List<CopyDto> getAllCopyPublicationId( @RequestParam int id  ) {
        List<CopyDto> copyDtos =  publicationService.findAllCopyByPublicationId( id );
        if( copyDtos.isEmpty() ) throw new ResourceNotFoundException(  "Il n'y a aucun exemplaire qui correspond à cette ouvrage." );

        return copyDtos;
    }

}
