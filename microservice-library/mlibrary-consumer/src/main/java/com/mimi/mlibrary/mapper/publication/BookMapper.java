package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.source.publication.Book;
import com.mimi.mlibrary.model.dest.publication.BookDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( config = BookMapperConfig.class )
public interface BookMapper {

    @InheritConfiguration( name = "mapBook")
    BookDto map( Book book );
    List<BookDto> map( List<Book> books );

}
