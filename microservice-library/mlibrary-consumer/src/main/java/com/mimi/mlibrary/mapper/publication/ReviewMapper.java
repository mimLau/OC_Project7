package com.mimi.mlibrary.mapper.publication;

import com.mimi.mlibrary.model.dest.publication.ReviewDto;
import com.mimi.mlibrary.model.source.publication.Review;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( config = ReviewMapperConfig.class )
public interface ReviewMapper {

    @InheritConfiguration( name = "mapReview")
    ReviewDto reviewToDto(Review review );
    List<ReviewDto> reviewToDtoList(List<Review> reviews );

    /*Review dtoToReview(ReviewDto reviewDto );
    List<Review> dtoToReviewList(List<ReviewDto> reviewDtos );*/
}
