package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import org.joda.time.LocalDate;

import java.util.List;
import java.util.Optional;

public interface BorrowingService {

    Borrowing findBorrowingById( int id );
    List<Borrowing> findAll();
    List<Borrowing> findByMemberId( int memberId );
    Borrowing save( Borrowing borrowing );
    void updateBorrowingReturnDateById( int extendedDay, int id );
}
