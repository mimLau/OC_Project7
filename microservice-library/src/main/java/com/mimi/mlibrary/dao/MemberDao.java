package com.mimi.mlibrary.dao;

import com.mimi.mlibrary.model.source.account.MemberAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MemberDao extends JpaRepository<MemberAccount, Integer> {

    @Query( "SELECT u FROM Member u WHERE u.id= :id" )
    MemberAccount getMemberById( @Param("id") Integer id);

    @Query( "SELECT u FROM Member u WHERE u.email= :email" )
    MemberAccount getMemberByEmail( @Param("email") String email);

    @Query( "SELECT u FROM Member u WHERE u.firstname= :firstname AND u.lastname= :lastname")
    MemberAccount getMemberByNames( @Param("firstname") String firstname, @Param("lastname") String lastname );

    @Modifying
    @Transactional
    @Query ("UPDATE Member u SET u.nbOfCurrentsBorrowings = u.nbOfCurrentsBorrowings + 1 WHERE u.barcode= :barcode")
    void incrementNbOfCurrentsBorrowings( @Param("barcode") String barcode );

}
