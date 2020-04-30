package com.mimi.batch.library.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    private Integer id;
    private boolean extented;
    private String LoanStatus;
    private Member member;
    private int reminderNb;
    private LocalDate returnDate;
    private LocalDate LoanDate;
    private Copy copy;


}
