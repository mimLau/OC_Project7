package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.entity.publication.Book;
import com.mimi.mlibrary.model.dto.publication.BookDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper( config = BookMapperConfig.class )
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper( BookMapper.class );

    @InheritConfiguration( name = "mapBook")
    BookDto toDto( Book book );
    List<BookDto> toDtoList( List<Book> books );

    Book toBook( BookDto bookDto );
    List<Book> toBookList( List<BookDto> bookDtos );

}
