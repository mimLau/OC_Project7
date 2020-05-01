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

    @Query("SELECT p FROM Publication p JOIN FETCH p.author a INNER JOIN p.copies c WHERE a.firstname= :name OR a.lastname= :name or a.alias= :name and ( :libId is null OR c.library.id= :libId )")
    List<Publication> findAllByAuthor( @Param("name") String name, @Param("libId") int libId );

    @Query("SELECT p FROM Publication p JOIN FETCH p.author a WHERE a.firstname= :name OR a.lastname= :name or a.alias= :name")
    List<Publication> findAllByAuthor( @Param("name") String name);

    @Query("SELECT p FROM Publication p INNER JOIN p.copies c WHERE ( :libId is null OR c.library.id= :libId ) AND p.title= :title")
    List<Publication> findAllByExactTitle( @Param("title") String title, @Param("libId") int libId );

    @Query("SELECT p FROM Publication p WHERE p.title= :title")
    List<Publication> findAllByExactTitle( @Param("title") String title);

    @Query("SELECT p FROM Publication p INNER JOIN p.copies c WHERE ( :libId is null OR c.library.id= :libId ) AND p.title LIKE %:title%")
    List<Publication> findAllByTitle( @Param("title") String title, @Param("libId") int libId  );

    @Query("SELECT p FROM Publication p WHERE p.title LIKE %:title%")
    List<Publication> findAllByTitle( @Param("title") String title );

    @Query("SELECT p FROM Publication p JOIN FETCH p.author a WHERE a.id= :id")
    List<Publication> findAllByAuthorId( @Param("id") int id );

    @Query("SELECT p FROM Publication p WHERE p.identificationNb= :idNb")
    Optional <Publication> findAllByIsbn( @Param("idNb") String idNb );

    @Modifying
    @Transactional
    @Query ("UPDATE Publication p SET p.nbOfAvailableCopies = p.nbOfAvailableCopies + :nbIncr WHERE p.id= :id")
    void updateNbOfAvailableCopies( @Param("id") int id, @Param("nbIncr") int nbIncr );

}
