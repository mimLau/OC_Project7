package com.mimi.mlibrary.model.dto.publication;

import com.mimi.mlibrary.model.entity.borrowing.Borrowing;
import com.mimi.mlibrary.model.entity.publication.Library;
import com.mimi.mlibrary.model.entity.publication.Publication;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CopyDto {

    private Integer id;
    private String barcode;
    private boolean available;
    private String returnDate;
    private Library library;

    private List<Borrowing> borrowings;
    private Publication publication;

}
