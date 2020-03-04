package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.dest.publication.BookDto;
import com.mimi.mlibrary.model.source.publication.Book;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface BookMapperConfig extends PublicationMapperConfig {

    @InheritConfiguration( name = "mapPublication")
    void mapBook( Book book, @MappingTarget BookDto bookDto );
}
