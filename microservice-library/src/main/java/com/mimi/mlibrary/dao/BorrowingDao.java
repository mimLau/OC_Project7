package com.mimi.mlibrary.dao;

import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowingDao extends JpaRepository<Borrowing, Integer> {

}
