package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.source.borrowing.Borrowing;

import java.util.List;
import java.util.Optional;

public interface BorrowingService {

    Optional<Borrowing> findBorrowingById(int id );
    List<Borrowing> findAll();
    List<Borrowing> findByMemberId( int memberId );
    Borrowing save( Borrowing borrowing, int memberId, int copyId );
    void updateBorrowingReturnDateById( int id );
    void  updateBorrowingExtensionValueById( int id) ;
    void  updateBorrowingStatus( int borrowingId );

}
