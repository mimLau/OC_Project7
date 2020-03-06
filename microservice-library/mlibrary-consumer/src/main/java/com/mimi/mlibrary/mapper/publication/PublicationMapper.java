package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.entity.publication.Publication;
import com.mimi.mlibrary.model.dto.publication.PublicationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PublicationMapper {

    PublicationMapper INSTANCE = Mappers.getMapper( PublicationMapper.class );

    PublicationDto toDto( Publication publication );
    List <PublicationDto> toDtoList( List<Publication> publications );

}
