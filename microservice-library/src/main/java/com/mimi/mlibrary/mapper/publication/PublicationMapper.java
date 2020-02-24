package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.source.publication.Publication;
import com.mimi.mlibrary.model.dest.publication.PublicationDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PublicationMapper {

    PublicationDto map( Publication publication );
    List <PublicationDto> map( List<Publication> publications );
}
