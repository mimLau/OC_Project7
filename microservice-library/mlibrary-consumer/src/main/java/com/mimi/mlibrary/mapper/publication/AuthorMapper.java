package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.entity.publication.Author;
import com.mimi.mlibrary.model.dto.publication.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper( AuthorMapper.class );

    AuthorDto toDto( Author author );
    List<AuthorDto> toDtoList( List<Author> authors );

    Author toEntity( AuthorDto authorDto );
    List<Author> toEntityList( List<AuthorDto> authorDtos );


}
