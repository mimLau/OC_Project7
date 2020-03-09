package com.mimi.mlibrary.model.entity.publication;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mimi.mlibrary.model.entity.borrowing.Borrowing;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import java.time.LocalDate;

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
    @Column(nullable = false)
    private String barcode;
    @Column(nullable = false)
    private boolean available;

    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate returnDate;

    @Column(nullable = false)
    @JsonManagedReference(value = "copy_borrowing")
    @OneToMany(mappedBy = "copy")
    private List<Borrowing> borrowings;

    @ManyToOne
    @JoinColumn(name="publication_fk")
    @JsonBackReference(value="publication_copy")
    private Publication publication;

    @ManyToOne
    @JoinColumn(name = "library_fk")
    private Library library;


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

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
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
