package com.mimi.mlibrary.service.contract;

import com.mimi.mlibrary.model.dto.borrowing.BorrowingDto;
import com.mimi.mlibrary.model.entity.borrowing.Borrowing;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BorrowingService {

    BorrowingDto findBorrowingById(int id );
    List<BorrowingDto> findAll();
    List<BorrowingDto> findByMemberId( int memberId );
    BorrowingDto save( BorrowingDto borrowingDto, int memberId, int copyId );
    void extendBorrowingReturnDateById( int borrowingId );
    //void  updateBorrowingExtensionValueById( int id) ;
    void  updateBorrowingStatus( int borrowingId );
    List<BorrowingDto> findByDelay();

}
