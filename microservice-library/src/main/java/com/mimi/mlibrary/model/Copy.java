package com.mimi.mlibrary.model;

import javax.persistence.*;

@Entity
@Table(name="Copies")
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String barcode;
    private Library library;
    private boolean available;
    private String returnDate;

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

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
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
}
