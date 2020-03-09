package com.mimi.mlibrary.repository.publication;

import com.mimi.mlibrary.model.entity.publication.Book;
import com.mimi.mlibrary.model.entity.publication.Newspaper;
import com.mimi.mlibrary.model.entity.publication.Publication;
import com.mimi.mlibrary.model.entity.publication.Review;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {


    @Query("SELECT b FROM Book b")
    List<Book> findAllBooks();

    @Query("SELECT n FROM Newspaper n")
    List<Newspaper> findAllNewspapers();

    @Query("SELECT n FROM Newspaper n WHERE n.publicationDate= :date")
    List<Newspaper> findAllNewspaperByDate( @Param("date") LocalDate date  );


    @Query("SELECT r FROM Review r")
    List<Review> findAllReviews();

    @Query("SELECT r FROM Review r WHERE r.publicationDate= :date")
    List<Review> findAllReviewsByDate( @Param("date") LocalDate date );


    @Query("SELECT p FROM Publication p WHERE p.id= :id")
    Optional<Publication> findPublicationById(@Param("id") int id );

    @Query("SELECT p FROM Publication p")
    List<Publication> findAllPublications();

    @Query("SELECT p FROM Publication p JOIN FETCH p.author a WHERE a.firstname= :name OR a.lastname= :name or a.alias= :name")
    List<Publication> findAllByAuthor( @Param("name") String name );

    //@Query("SELECT p FROM Publication p  WHERE p.title LIKE %:title%")
   @Query("SELECT p FROM Publication p  WHERE p.title= :title")
    List<Publication> findAllByTitle( @Param("title") String title );

    @Query("SELECT p FROM Publication p JOIN FETCH p.author a WHERE a.id= :id")
    List<Publication> findAllByAuthorId( @Param("id") int id );

    @Query("SELECT p FROM Publication p WHERE p.publicationDate= :date")
    List<Publication> findAllByDate( @Param("date") String date );


    @Query("SELECT p FROM Publication p WHERE p.identificationNb= :idNb")
    Optional <Publication> findAllByIsbn( @Param("idNb") String idNb );






}
