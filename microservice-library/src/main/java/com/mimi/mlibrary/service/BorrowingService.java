package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.dest.borrowing.BorrowingDto;
import com.mimi.mlibrary.model.source.borrowing.Borrowing;

import java.util.List;

public interface BorrowingService {

    //List<BorrowingDto> findAll();
    List<Borrowing> findByMemberId( int memberId );
}
