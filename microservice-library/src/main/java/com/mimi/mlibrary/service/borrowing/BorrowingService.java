package com.mimi.mlibrary.service.borrowing;

import com.mimi.mlibrary.model.dest.borrowing.BorrowingDto;
import com.mimi.mlibrary.model.source.borrowing.Borrowing;

import java.util.List;

public interface BorrowingService {

    List<Borrowing> findAll();
    List<Borrowing> findByMemberId( int memberId );
}
