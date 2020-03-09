package org.mimi.clibrary.Beans.account;

import org.mimi.clibrary.Beans.borrowing.BorrowingBean;

import java.util.List;

public class MemberBean extends AccountBean {

    private String barcode;
    private int nbOfCurrentsBorrowings;
    private List<BorrowingBean> borrowings;

    public MemberBean() {
    }

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

    public List<BorrowingBean> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<BorrowingBean> borrowings) {
        this.borrowings = borrowings;
    }
}
