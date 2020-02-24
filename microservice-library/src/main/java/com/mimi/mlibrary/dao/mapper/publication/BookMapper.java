package com.mimi.mlibrary.dao.mapper.publication;

import com.mimi.mlibrary.model.source.publication.Book;
import com.mimi.mlibrary.model.dest.publication.BookDto;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {

    BookDto map( Book book );
}
