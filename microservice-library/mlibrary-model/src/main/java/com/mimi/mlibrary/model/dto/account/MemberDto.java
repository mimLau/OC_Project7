package com.mimi.mlibrary.model.dto.account;


import com.mimi.mlibrary.model.entity.loan.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto extends AccountDto {

    private String barcode;
    private int nbOfCurrentsLoans;
    private List<Loan> Loans;
}
