package com.mimi.mlibrary.repository.account;

import com.mimi.mlibrary.model.entity.account.Member;
import com.mimi.mlibrary.model.entity.loan.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query( "SELECT m FROM Member m WHERE m.accountOwnerEmail= :mail AND m.accountOwnerPass= :pass" )
    Optional<Member> getMemberByEmailAndPass( @Param("mail") String mail, @Param("pass") String pass );

    @Query( "SELECT m FROM Member m WHERE m.id= :id" )
    Optional<Member> getMemberById( @Param("id") Integer id);

    @Query( "SELECT m FROM Member m WHERE m.accountOwnerEmail= :email" )
    Optional<Member> getMemberByEmail( @Param("email") String email );

    @Query( "SELECT m FROM Member m WHERE m.accountOwnerFirstname= :firstname AND m.accountOwnerLastname= :lastname")
    Optional<Member> getMemberByNames( @Param("firstname") String firstname, @Param("lastname") String lastname );

    @Query( "SELECT m FROM Member m JOIN m.Loans b WHERE b.returnDate < :current_date AND b.loanStatus= :status" )
    List<Member> getMembersByOutdatedLoan( @Param("current_date") LocalDate currentDate, @Param("status") LoanStatus status );

    @Modifying
    @Transactional
    @Query ("UPDATE Member m SET m.nbOfCurrentsLoans= m.nbOfCurrentsLoans + :nbIncr WHERE m.id= :id")
    void updateNbOfCurrentsLoans( @Param("id") int id, @Param("nbIncr") int nbIncr );



}
