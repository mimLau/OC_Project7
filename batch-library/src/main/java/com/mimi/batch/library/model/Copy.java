package com.mimi.batch.library.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Copy {

    private Integer id;
    private String barcode;
    private boolean available;
    private LocalDate returnDate;
    private List<Loan> Loans;
    private Publication publication;


}
