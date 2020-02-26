package com.mimi.mlibrary.dao.publication;

import com.mimi.mlibrary.model.source.publication.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {
}
