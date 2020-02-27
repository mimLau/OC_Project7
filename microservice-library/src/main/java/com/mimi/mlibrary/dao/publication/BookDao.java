package com.mimi.mlibrary.dao.publication;

import com.mimi.mlibrary.model.source.publication.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b JOIN FETCH b.author a WHERE a.firstname= :name OR a.lastname= :name or a.alias= :name")
    List<Book> findAllByAuthor( @Param("name") String name );

    @Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
    List<Book> findAllByTitle( @Param("title") String title );

    @Query("SELECT b FROM Book b JOIN FETCH b.author a WHERE a.id= :id")
    List<Book> findAllByAuthorId( @Param("id") int id );
}
