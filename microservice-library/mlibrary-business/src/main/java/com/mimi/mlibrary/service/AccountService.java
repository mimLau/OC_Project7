package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.dest.account.MemberDto;
import com.mimi.mlibrary.model.source.account.Member;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<MemberDto> findAll();
    MemberDto findById( int id );
    MemberDto save(Member Member);
    MemberDto getMemberById( Integer id );
    MemberDto getMemberByEmail( String email);
    MemberDto getMemberByNames( String firstname, String lastname );
    void updateNbOfCurrentsBorrowings( int id );
}
