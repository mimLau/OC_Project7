package com.mimi.mlibrary.model.entity.account;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mimi.mlibrary.model.entity.loan.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Member")
public class Member extends Account {

    private String barcode;
    private int nbOfCurrentsLoans;
    @JsonManagedReference(value = "Loan_member")
    @OneToMany(mappedBy = "member")
    private List<Loan> loans;

}
