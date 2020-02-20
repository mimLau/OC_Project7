package com.mimi.mlibrary.dao;

import com.mimi.mlibrary.model.works.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkDao extends JpaRepository<Work, Integer> {

   @Query("SELECT w FROM Work w WHERE w.isbn= :isbn")
   Work searchWorkByIsbn( @Param("isbn") String isbn );

   @Query("SELECT w FROM Work w WHERE w.author.name LIKE %:name%")
   List<Work> searchWorksByAuthorName( @Param("name") String name );

   @Query("SELECT w FROM Work w WHERE w.title LIKE %:title%")
   List<Work> searchWorksByTitle( @Param("title") String title );


}
