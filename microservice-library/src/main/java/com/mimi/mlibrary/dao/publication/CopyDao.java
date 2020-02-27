package com.mimi.mlibrary.dao.publication;

import com.mimi.mlibrary.model.source.publication.Copy;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CopyDao extends JpaRepository<Copy, Integer> {

    @Query("Select  c FROM Copy c JOIN FETCH c.book b where b.id= :id")
    List<Copy> findAllByBookId( @Param( "id" ) int id );

    @Query("Select  c FROM Copy c JOIN FETCH c.review b where b.id= :id")
    List<Copy> findAllByReviewId( @Param( "id" ) int id );

    @Query("Select  c FROM Copy c JOIN FETCH c.newspaper b where b.id= :id")
    List<Copy> findAllByNewspaperId( @Param( "id" ) int id );

    @Query("SELECT c FROM Copy c WHERE c.returnDate < :today")
    List<Copy> findAllByDelay( @Param("today") LocalDate currentDate );
}
