package com.mimi.mlibrary.model.dto.publication;


import com.mimi.mlibrary.model.entity.loan.Loan;
import com.mimi.mlibrary.model.entity.publication.Library;
import com.mimi.mlibrary.model.entity.publication.Publication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CopyDto {

    private Integer id;
    private String barcode;
    private boolean available;
    private String returnDate;
    private Library library;

    private List<Loan> Loans;
    private Publication publication;

}
