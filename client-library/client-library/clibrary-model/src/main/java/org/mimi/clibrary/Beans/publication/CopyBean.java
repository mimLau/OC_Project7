package org.mimi.clibrary.Beans.publication;

import java.time.LocalDate;
import org.mimi.clibrary.Beans.Loan.LoanBean;

import java.util.List;

public class CopyBean {

    private Integer id;
    private String barcode;
    private boolean available;
    private LocalDate returnDate;
    private List<LoanBean> Loans;
    private PublicationBean publication;
    private LibraryBean library;


    public CopyBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public List<LoanBean> getLoans() {
        return Loans;
    }

    public void setLoans(List<LoanBean> Loans) {
        this.Loans = Loans;
    }

    public PublicationBean getPublication() {
        return publication;
    }

    public void setPublication(PublicationBean publication) {
        this.publication = publication;
    }

    public LibraryBean getLibrary() {
        return library;
    }

    public void setLibrary(LibraryBean library) {
        this.library = library;
    }
}
