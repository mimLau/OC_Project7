package com.mimi.mlibrary.model.entity.publication;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "publications")
public  class Publication implements Serializable {

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
    private String title;

    @Column(nullable = false)
    private String identificationNb;
    @Column(nullable = false)
    private int nbOfAvailableCopies;
    @Column(nullable = false)
    private int nbTotalOfcopies;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SubCategory subCategory;

    @JsonBackReference( value="publication_copy")
    @OneToMany(mappedBy = "publication")
    private List<Copy> copies;

    @ManyToOne
    @JsonBackReference(value="publication_author")
    @JoinColumn(name="author_fk")
    private Author author;

    @ManyToOne
    @JsonBackReference(value="publication_editor")
    @JoinColumn(name = "edithor_fk")
    private Editor editor;

    private LocalDate publicationDate;

}
