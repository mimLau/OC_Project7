package com.mimi.mlibrary.dao.publication;

import com.mimi.mlibrary.model.source.publication.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao extends JpaRepository<Review, Integer> {

    @Query("SELECT r FROM Review r WHERE r.name= :name")
    List<Review> findAllByName( @Param("name") String name );

    @Query("SELECT r FROM Review r WHERE r.releaseDate= :date")
    List<Review> findAllByDate( @Param("date") String date );
}
