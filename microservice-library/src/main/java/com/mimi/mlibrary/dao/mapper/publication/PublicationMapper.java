package com.mimi.mlibrary.dao.mapper.publication;

import com.mimi.mlibrary.model.publication.Publication;
import com.mimi.mlibrary.model.publication.PublicationDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PublicationMapper {

    PublicationDto map( Publication publication );
    List <PublicationDto> map( List<Publication> publications );
}
