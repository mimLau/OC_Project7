package com.mimi.mlibrary.service.contract;

import com.mimi.mlibrary.model.dto.loan.LoanDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface LoanService {

    LoanDto findLoanById(int id );
    List<LoanDto> findAll();
    List<LoanDto> findByMemberId( int memberId );
    LoanDto save( int memberId, int copyId );
    void extendLoanReturnDateById( int LoanId );
    void  updateLoanStatus( int LoanId );
    List<LoanDto> findByDelay();
    Map<String, LocalDate> findOutdatedLoansEmailMember();

}
