package com.mimi.mlibrary.model.source.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Member")
public class MemberAccount extends Account {

    private String barcode;
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
