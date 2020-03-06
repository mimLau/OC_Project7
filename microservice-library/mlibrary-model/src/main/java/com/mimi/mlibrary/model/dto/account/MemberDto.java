package com.mimi.mlibrary.model.dto.account;

import com.mimi.mlibrary.model.entity.borrowing.Borrowing;

import java.util.List;

public class MemberDto extends AccountDto {

    private String barcode;
    private int nbOfCurrentsBorrowings;
    private List<Borrowing> borrowings;


    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getNbOfCurrentsBorrowings() {
        return nbOfCurrentsBorrowings;
    }

    public void setNbOfCurrentsBorrowings(int nbOfCurrentsBorrowings) {
        this.nbOfCurrentsBorrowings = nbOfCurrentsBorrowings;
    }

    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }
}
