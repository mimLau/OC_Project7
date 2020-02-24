package com.mimi.mlibrary.model.mapper.publication;

import com.mimi.mlibrary.model.publication.Book;
import com.mimi.mlibrary.model.publication.BookDto;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {

    BookDto map( Book book );
}
