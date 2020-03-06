package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.dto.publication.NewspaperDto;
import com.mimi.mlibrary.model.entity.publication.Newspaper;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface NewspaperMapperConfig extends PublicationMapperConfig {

    @InheritConfiguration( name = "mapPublication")
    void mapNews( Newspaper newspaper, @MappingTarget NewspaperDto newspaperDto );
}
