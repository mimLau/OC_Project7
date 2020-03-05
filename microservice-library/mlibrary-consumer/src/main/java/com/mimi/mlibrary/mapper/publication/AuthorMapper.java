package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.source.publication.Author;
import com.mimi.mlibrary.model.dest.publication.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper( AuthorMapper.class );
    AuthorDto authToDto( Author author );
    List<AuthorDto> authToDtoList( List<Author> authors );

    Author dtoToAuth( AuthorDto authorDto );
    List<Author> dtoToAuthList( List<AuthorDto> authorDtos );


}
