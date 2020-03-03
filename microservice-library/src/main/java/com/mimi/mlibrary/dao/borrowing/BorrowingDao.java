package com.mimi.mlibrary.dao.borrowing;

import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import com.mimi.mlibrary.model.source.borrowing.BorrowingStatus;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowingDao extends JpaRepository<Borrowing, Integer> {

    @Query("SELECT b FROM Borrowing b WHERE b.id= :id")
    Optional<Borrowing> findBorrowingById(@Param("id") int id );

    @Query("SELECT b FROM Borrowing  b JOIN FETCH b.member m WHERE m.id= :id")
    List<Borrowing> findByMemberId(@Param("id") int id);

    @Query("SELECT b FROM Borrowing  b JOIN FETCH b.copy c WHERE c.id= :id")
    List<Borrowing> findByCopyId( @Param("id") int id );

    @Transactional
    @Modifying
    @Query("Update Borrowing b SET b.returnDate= :newDate WHERE b.id= :id")
    void  updateBorrowingReturnDateById( @Param("newDate") LocalDate newDate, @Param("id") int id );

    @Transactional
    @Modifying
    @Query("Update Borrowing b SET b.extented= true WHERE b.id= :id")
    void  updateExtensionById( @Param("id") int id );

    @Transactional
    @Modifying
    @Query("Update Borrowing b SET b.borrowingStatus= :status WHERE b.id= :id ")
    void  updateBorrowingStatus( @Param("id") int id, @Param("status") BorrowingStatus borrowingStatus );

}
