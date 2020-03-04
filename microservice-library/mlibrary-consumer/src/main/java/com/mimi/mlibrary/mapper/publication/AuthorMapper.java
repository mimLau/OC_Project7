package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.dest.publication.AuthorDto;
import com.mimi.mlibrary.model.source.publication.Author;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AuthorMapper {

    AuthorDto map( Author author );
    List<AuthorDto> map(List<Author> authors );
}
