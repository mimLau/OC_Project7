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

    @Query("SELECT b FROM Loan b WHERE b.loanStatus= :status")
    List<Loan> findAllLoans( @Param("status") LoanStatus status );

    @Query("SELECT b FROM Loan b WHERE b.id= :id")
    Optional<Loan> findLoanById(@Param("id") int id );

    @Query("SELECT b FROM Loan  b JOIN FETCH b.member m WHERE m.id= :id and b.loanStatus= :status")
    List<Loan> findByMemberId(@Param("id") int id, @Param("status") LoanStatus status );

    @Query("SELECT b FROM Loan  b JOIN FETCH b.copy c WHERE c.id= :id")
    List<Loan> findByCopyId( @Param("id") int id );

    @Query("SELECT b FROM Loan b WHERE b.returnDate < :current_date AND b.loanStatus= :status")
    List<Loan> findByDelay( @Param("current_date") LocalDate currentDate, @Param("status") LoanStatus status );

    @Transactional
    @Modifying
    @Query("Update Loan b SET b.returnDate= :newDate WHERE b.id= :id")
    void  updateLoanReturnDateById(@Param("newDate") LocalDate newDate, @Param("id") int id );

    @Transactional
    @Modifying
    @Query("Update Loan b SET b.extented= true WHERE b.id= :id")
    void  updateExtensionById( @Param("id") int id );

    @Transactional
    @Modifying
    @Query("Update Loan b SET b.loanStatus= :status WHERE b.id= :id ")
    void  updateLoanStatus( @Param("id") int id, @Param("status") LoanStatus loanStatus );

}
