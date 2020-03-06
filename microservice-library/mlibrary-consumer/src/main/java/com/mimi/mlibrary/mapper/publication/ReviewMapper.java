package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.dest.publication.ReviewDto;
import com.mimi.mlibrary.model.source.publication.Review;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper( config = ReviewMapperConfig.class )
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper( ReviewMapper.class );

    @InheritConfiguration( name = "mapReview")
    ReviewDto toDto(Review review );
    List<ReviewDto> toDtoList(List<Review> reviews );

    Review toEntity(ReviewDto reviewDto );
    List<Review> toEntityList(List<ReviewDto> reviewDtos );
}
