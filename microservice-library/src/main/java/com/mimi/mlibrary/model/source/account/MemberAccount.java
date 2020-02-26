package com.mimi.mlibrary.model.source.account;

import com.mimi.mlibrary.model.source.borrowing.Borrowing;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table( name = "Members")
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

    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }
}
