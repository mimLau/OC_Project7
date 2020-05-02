package com.mimi.mlibrary.repository.publication;

import com.mimi.mlibrary.model.entity.publication.Publication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer>, JpaSpecificationExecutor<Publication> {


    /*@Query("SELECT b FROM Book b")
    Page<Book> findAllBooks( Pageable pageable );*/

    @Query("SELECT p FROM Publication p WHERE p.id= :id")
    Optional<Publication> findPublicationById(@Param("id") int id );

    @Query("SELECT p FROM Publication p")
    List<Publication> findAllPublications();

    @Modifying
    @Transactional
    @Query ("UPDATE Publication p SET p.nbOfAvailableCopies = p.nbOfAvailableCopies + :nbIncr WHERE p.id= :id")
    void updateNbOfAvailableCopies( @Param("id") int id, @Param("nbIncr") int nbIncr );

}
