package com.mimi.mlibrary.model.works;

import com.mimi.mlibrary.model.borrowings.Borrowing;
import com.mimi.mlibrary.model.users.Library;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Copies")
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String barcode;
    private boolean available;
    private String returnDate;

    @OneToOne
    private Work work;

    @ManyToOne
    @JoinColumn
    private Library library;

    @OneToMany(mappedBy = "copy")
    private List<Borrowing> borrowings;

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

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
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
}
