package com.mimi.mlibrary.model.user;

import com.mimi.mlibrary.model.borrowing.Borrowing;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("Member")
public class Member extends User implements Serializable {

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
