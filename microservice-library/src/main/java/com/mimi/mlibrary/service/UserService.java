package com.mimi.mlibrary.service;

import com.mimi.mlibrary.model.users.Member;
import com.mimi.mlibrary.model.users.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    Optional<User> findById( int id );
    List<Member> getAllMember();
    Member save(Member member);
    Member getMemberById( Integer id );
    Member getMemberByEmail( String email);
    Member getMemberByNames( String firstname, String lastname );
    void incrementNbOfCurrentsBorrowings( String barcode );
}
