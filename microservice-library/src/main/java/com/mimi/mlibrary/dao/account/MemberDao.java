package com.mimi.mlibrary.dao.account;

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

    @Query( "SELECT m FROM MemberAccount m WHERE m.id= :id" )
    MemberAccount getMemberById( @Param("id") Integer id);

    @Query( "SELECT m FROM MemberAccount m WHERE m.accountOwnerEmail= :email" )
    MemberAccount getMemberByEmail( @Param("email") String email);

    @Query( "SELECT m FROM MemberAccount m WHERE m.accountOwnerFirstname= :firstname AND m.accountOwnerLastname= :lastname")
    MemberAccount getMemberByNames( @Param("firstname") String firstname, @Param("lastname") String lastname );

    @Modifying
    @Transactional
    @Query ("UPDATE MemberAccount m SET m.nbOfCurrentsBorrowings = m.nbOfCurrentsBorrowings + 1 WHERE m.barcode= :barcode")
    void incrementNbOfCurrentsBorrowings( @Param("barcode") String barcode );

}
