package com.mimi.mlibrary.dao.publication;

import com.mimi.mlibrary.model.source.publication.Newspaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface NewspaperDao extends JpaRepository<Newspaper, Integer> {

    @Query("SELECT n FROM Newspaper n WHERE n.name= :name")
    List<Newspaper> findAllByName( @Param("name") String name );

    @Query("SELECT n FROM Newspaper n WHERE n.releaseDate= :date")
    List<Newspaper> findAllByDate( @Param("date") String date );
}
