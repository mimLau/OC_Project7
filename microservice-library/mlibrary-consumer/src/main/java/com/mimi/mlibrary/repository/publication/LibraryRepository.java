package com.mimi.mlibrary.repository.publication;

import com.mimi.mlibrary.model.entity.publication.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

    @Query("SELECT l FROM Library l")
    List<Library> findAllLibraries();
}
