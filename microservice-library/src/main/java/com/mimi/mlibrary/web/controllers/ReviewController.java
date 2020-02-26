package com.mimi.mlibrary.web.controllers;

import com.mimi.mlibrary.model.source.publication.Newspaper;
import com.mimi.mlibrary.model.source.publication.Review;
import com.mimi.mlibrary.service.publication.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    private ReviewService reviewService;


    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping( value = "/Reviews")
    public List<Review> findAll(){
        return reviewService.findAll();
    }

    @GetMapping( value = "/Reviews", params = "name")
    public List<Review> findAllByName( @RequestParam String name ){
        return reviewService.findAllByName( name );
    }

    @GetMapping( value = "/Reviews", params = "date")
    public List<Review> findAllByDate( @RequestParam String date ){
        return reviewService.findAllByDate( date );
    }
}
