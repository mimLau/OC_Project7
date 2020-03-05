package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.source.publication.Publication;
import com.mimi.mlibrary.model.dest.publication.PublicationDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PublicationMapper {

    PublicationMapper INSTANCE = Mappers.getMapper( PublicationMapper.class );
    PublicationDto pubToDto( Publication publication );
    List <PublicationDto> pubToDtoList( List<Publication> publications );

    /*Publication dtoToPub( PublicationDto publicationDto );
    List <Publication> dtoToPubList( List<PublicationDto> publicationDtos );*/




}
