package com.mimi.mlibrary.model.entity.publication;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mimi.mlibrary.model.entity.borrowing.Borrowing;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
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
    //@JsonManagedReference(value="publication_copy")
    private Publication publication;

    @ManyToOne
    @JoinColumn(name = "library_fk")
    private Library library;
}
