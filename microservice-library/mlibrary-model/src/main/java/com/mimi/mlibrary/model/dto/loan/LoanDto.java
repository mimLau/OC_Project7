package com.mimi.mlibrary.model.dto.loan;

import com.mimi.mlibrary.model.entity.account.Member;
import com.mimi.mlibrary.model.entity.publication.Copy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {

    private Integer id;

    private LocalDate returnDate;
    private LocalDate LoanDate;
    private int reminderNb;
    private boolean extented;
    private String LoanStatus;
    private Copy copy;
    private Member member;

}
