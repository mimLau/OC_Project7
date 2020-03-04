package com.mimi.mlibrary.dao.account;

import com.mimi.mlibrary.model.source.account.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface MemberDao extends JpaRepository<Member, Integer> {

    @Query( "SELECT m FROM Member m WHERE m.id= :id" )
    Optional<Member> getMemberById(@Param("id") Integer id);

    @Query( "SELECT m FROM Member m WHERE m.accountOwnerEmail= :email" )
    Optional<Member> getMemberByEmail(@Param("email") String email);

    @Query( "SELECT m FROM Member m WHERE m.accountOwnerFirstname= :firstname AND m.accountOwnerLastname= :lastname")
    Optional<Member> getMemberByNames(@Param("firstname") String firstname, @Param("lastname") String lastname );

    @Modifying
    @Transactional
    @Query ("UPDATE Member m SET m.nbOfCurrentsBorrowings= m.nbOfCurrentsBorrowings + :nbIncr WHERE m.id= :id")
    void updateNbOfCurrentsBorrowings( @Param("id") int id, @Param("nbIncr") int nbIncr );



}
