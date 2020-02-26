package com.mimi.mlibrary.service.publication;

import com.mimi.mlibrary.model.source.publication.Review;

import java.util.List;

public interface ReviewService {

    List<Review> findAll();
    List<Review> findAllByName( String name );
    List<Review> findAllByDate(String date );
}
