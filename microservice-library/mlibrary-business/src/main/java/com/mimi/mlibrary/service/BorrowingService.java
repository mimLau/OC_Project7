package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.dest.borrowing.BorrowingDto;
import com.mimi.mlibrary.model.source.borrowing.Borrowing;

import java.util.List;

public interface BorrowingService {

    BorrowingDto findBorrowingById(int id );
    List<BorrowingDto> findAll();
    List<BorrowingDto> findByMemberId( int memberId );
    BorrowingDto save( Borrowing borrowing, int memberId, int copyId );
    void updateBorrowingReturnDateById( int id );
    void  updateBorrowingExtensionValueById( int id) ;
    void  updateBorrowingStatus( int borrowingId );

}
