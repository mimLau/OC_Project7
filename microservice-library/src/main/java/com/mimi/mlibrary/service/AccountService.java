package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.source.account.MemberAccount;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<MemberAccount> findAll();
    Optional<MemberAccount> findById( int id );
    MemberAccount save(MemberAccount Member);
    Optional<MemberAccount> getMemberById( Integer id );
    Optional<MemberAccount> getMemberByEmail( String email);
    Optional<MemberAccount> getMemberByNames( String firstname, String lastname );
    void incrementNbOfCurrentsBorrowings( String barcode );
}
