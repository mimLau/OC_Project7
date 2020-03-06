package com.mimi.mlibrary.model.entity.account;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mimi.mlibrary.model.entity.borrowing.Borrowing;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Member")
public class Member extends Account {

    private String barcode;
    @Column(nullable = false)
    private int nbOfCurrentsBorrowings;


    @OneToMany(mappedBy = "member")
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

    @JsonManagedReference(value = "borrowing_member")
    @OneToMany(mappedBy = "member")
    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }
}
