package com.mimi.mlibrary.service.impl.publication;

import com.mimi.mlibrary.dao.publication.ReviewDao;
import com.mimi.mlibrary.model.source.publication.Review;
import com.mimi.mlibrary.service.publication.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewSericeImpl implements ReviewService {

    private ReviewDao reviewDao;

    public ReviewSericeImpl(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public List<Review> findAll() {
        return reviewDao.findAll();
    }

    @Override
    public List<Review> findAllByName( String name ) {
        return reviewDao.findAllByName( name );
    }

    @Override
    public List<Review> findAllByDate( String date ) {
        return reviewDao.findAllByDate( date );
    }
}
