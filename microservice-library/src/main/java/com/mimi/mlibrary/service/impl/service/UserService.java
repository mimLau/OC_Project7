package com.mimi.mlibrary.service.impl.service;

import com.mimi.mlibrary.model.users.Member;

import java.util.List;

public interface UserService {

    List<Member> getAllMember();
    Member getMemberById( Integer id );
    Member getMemberByEmail( String email);
    Member getMemberByNames( String firstname, String lastname );
    void incrementNbOfCurrentsBorrowings( String barcode );
}
