package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.source.publication.Newspaper;
import com.mimi.mlibrary.model.dest.publication.NewspaperDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( config = NewspaperMapperConfig.class )
public interface NewspaperMapper {

    @InheritConfiguration( name = "mapNews")
    NewspaperDto newsToDto( Newspaper newspaper );
    List<NewspaperDto> newsToDtoList( List<Newspaper> newspapers );

    /*Newspaper dtoToNews( NewspaperDto newspaperDto );
    List<Newspaper> dtoToNewsList( List<NewspaperDto> newspaperDtos );*/
}
