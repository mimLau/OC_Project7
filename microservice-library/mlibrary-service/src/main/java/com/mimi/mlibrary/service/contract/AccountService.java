package com.mimi.mlibrary.service.contract;

import com.mimi.mlibrary.model.dto.account.MemberDto;

import java.util.List;

public interface AccountService {

    List<MemberDto> findAll();
    MemberDto findById( int id );
    MemberDto save( MemberDto memberDto );
    MemberDto getMemberById( Integer id );
    MemberDto getMemberByEmail( String email );
    MemberDto getMemberByNames( String firstname, String lastname );
    void updateNbOfCurrentsBorrowings( int id );
}
