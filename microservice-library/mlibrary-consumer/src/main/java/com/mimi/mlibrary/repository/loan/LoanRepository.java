package com.mimi.mlibrary.repository.loan;

import com.mimi.mlibrary.model.entity.loan.Loan;
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
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    @Query("SELECT l FROM Loan l WHERE l.loanStatus= :status")
    List<Loan> findAllLoans( @Param("status") LoanStatus status );

    @Query("SELECT l FROM Loan l WHERE l.id= :id")
    Optional<Loan> findLoanById(@Param("id") int id );

    @Query("SELECT l FROM Loan  l JOIN FETCH l.member m WHERE m.id= :id and l.loanStatus= :status")
    List<Loan> findByMemberId(@Param("id") int id, @Param("status") LoanStatus status );

    @Query("SELECT l FROM Loan l WHERE l.returnDate < :current_date AND l.loanStatus= :status")
    List<Loan> findByDelay( @Param("current_date") LocalDate currentDate, @Param("status") LoanStatus status );

    @Transactional
    @Modifying
    @Query("Update Loan l SET l.returnDate= :newDate WHERE l.id= :id")
    void  updateLoanReturnDateById(@Param("newDate") LocalDate newDate, @Param("id") int id );

    @Transactional
    @Modifying
    @Query("Update Loan l SET l.extented= :extVal WHERE l.id= :id")
    void  updateExtensionById( @Param("id") int id, @Param("extVal") Boolean extVal);

    @Transactional
    @Modifying
    @Query("Update Loan l SET l.loanStatus= :status WHERE l.id= :id ")
    void  updateLoanStatus( @Param("id") int id, @Param("status") LoanStatus loanStatus );

    @Transactional
    @Modifying
    @Query("Update Loan l SET l.reminderNb= l.reminderNb + 1 WHERE l.id= :id")
    void  updateReminderNbById( @Param("id") int id );

}
