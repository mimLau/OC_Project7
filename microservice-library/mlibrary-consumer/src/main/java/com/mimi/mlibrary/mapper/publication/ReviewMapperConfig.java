package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.dest.publication.ReviewDto;
import com.mimi.mlibrary.model.source.publication.Review;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface ReviewMapperConfig extends PublicationMapperConfig {

    @InheritConfiguration( name = "mapPublication")
    void mapReview(Review review, @MappingTarget ReviewDto reviewDto );
}
