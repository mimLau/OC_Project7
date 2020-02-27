package com.mimi.mlibrary.model.source.publication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mimi.mlibrary.model.source.borrowing.Borrowing;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Copies")
public class Copy {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Integer id;
    private String barcode;
    private boolean available;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate returnDate;


    @JsonIgnore
    @OneToOne
    private Book book;

    @JsonIgnore
    @OneToOne
    private Review review;

    @JsonIgnore
    @OneToOne
    private Newspaper newspaper;

    @ManyToOne
    @JoinColumn
    private Library library;

    @JsonManagedReference(value = "copy")
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

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Newspaper getNewspaper() {
        return newspaper;
    }

    public void setNewspaper(Newspaper newspaper) {
        this.newspaper = newspaper;
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
