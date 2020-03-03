package com.mimi.mlibrary.dao.publication;

import com.mimi.mlibrary.model.source.publication.Copy;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CopyDao extends JpaRepository<Copy, Integer> {

    @Query("Select  c FROM Copy c where c.id= :id")
    Copy findCopyById( int id );

    @Query("Select  c FROM Copy c JOIN FETCH c.publication p where p.id= :id")
    List<Copy> findAllCopyByPublicationId( @Param( "id" ) int id );

    @Query("SELECT c FROM Copy c WHERE c.returnDate < :today")
    List<Copy> findAllByDelay( @Param("today") LocalDate currentDate );


    @Transactional
    @Modifying
    @Query("Update Copy c SET c.returnDate= :newDate WHERE c.id= :id")
    void  updateCopyReturnDateById( @Param("newDate") LocalDate newDate, @Param("id") int id );

    @Transactional
    @Modifying
    @Query("Update Copy c SET c.available= :available WHERE c.id= :id")
    void  updateCopyAvailability( @Param("available") boolean available, @Param("id") int id );

}
