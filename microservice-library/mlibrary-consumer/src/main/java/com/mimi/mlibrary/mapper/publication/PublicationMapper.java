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

    PublicationDto toDto( Publication publication );
    List <PublicationDto> toDtoList( List<Publication> publications );

}
