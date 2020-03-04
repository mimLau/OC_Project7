package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.dest.publication.NewspaperDto;
import com.mimi.mlibrary.model.source.publication.Newspaper;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( config = NewspaperMapperConfig.class )
public interface NewspaperMapper {

    @InheritConfiguration( name = "mapNews")
    NewspaperDto map( Newspaper newspaper );
    List<NewspaperDto> map( List<Newspaper> newspapers );
}
