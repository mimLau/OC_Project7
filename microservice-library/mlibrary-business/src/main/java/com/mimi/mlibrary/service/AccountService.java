package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.source.account.Member;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Member> findAll();
    Optional<Member> findById(int id );
    Member save(Member Member);
    Optional<Member> getMemberById(Integer id );
    Optional<Member> getMemberByEmail(String email);
    Optional<Member> getMemberByNames(String firstname, String lastname );
    void updateNbOfCurrentsBorrowings( int id );
}
