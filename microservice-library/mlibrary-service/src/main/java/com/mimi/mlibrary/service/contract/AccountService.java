package com.mimi.mlibrary.service.contract;

import com.mimi.mlibrary.model.dto.account.EmployeeDto;
import com.mimi.mlibrary.model.dto.account.MemberDto;
import java.util.List;

public interface AccountService {

    MemberDto findMemberByMailAndPass( String mail, String password );
    EmployeeDto findEmployeeByMailAndPass( String mail, String password );
    List<MemberDto> findAll();
    MemberDto findById( int id );
    MemberDto save( MemberDto memberDto );
    MemberDto getMemberById( Integer id );
    MemberDto getMemberByEmail( String email );
    MemberDto getMemberByNames( String firstname, String lastname );
    void updateNbOfCurrentsLoans( int id );
    List<MemberDto> getMembersByOutdatedLoan( );

}
