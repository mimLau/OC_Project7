package com.mimi.mlibrary.model.dto.publication;

import com.mimi.mlibrary.model.entity.borrowing.Borrowing;
import com.mimi.mlibrary.model.entity.publication.Library;
import com.mimi.mlibrary.model.entity.publication.Publication;

import java.util.List;


public class CopyDto {

    private Integer id;
    private String barcode;
    private boolean available;
    private String returnDate;
    private Library library;

    private List<Borrowing> borrowings;
    private Publication publication;


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

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
}
