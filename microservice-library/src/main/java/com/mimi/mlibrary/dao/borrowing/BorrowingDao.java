package com.mimi.mlibrary.dao.borrowing;

import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowingDao extends JpaRepository<Borrowing, Integer> {

    @Query("SELECT b FROM Borrowing  b JOIN FETCH b.member m WHERE m.id= :id")
    List<Borrowing> findByMemberId(@Param("id") int id);

}
