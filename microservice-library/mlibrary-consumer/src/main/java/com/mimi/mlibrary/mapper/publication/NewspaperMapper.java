package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.entity.publication.Newspaper;
import com.mimi.mlibrary.model.dto.publication.NewspaperDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper( config = NewspaperMapperConfig.class )
public interface NewspaperMapper {

    NewspaperMapper INSTANCE = Mappers.getMapper( NewspaperMapper.class );

    @InheritConfiguration( name = "mapNews")
    NewspaperDto toDto( Newspaper newspaper );
    List<NewspaperDto> toDtoList( List<Newspaper> newspapers );

    Newspaper toEntity( NewspaperDto newspaperDto );
    List<Newspaper> toEntityList( List<NewspaperDto> newspaperDtos );
}
