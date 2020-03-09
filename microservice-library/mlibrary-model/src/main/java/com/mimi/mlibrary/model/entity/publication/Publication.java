package com.mimi.mlibrary.model.entity.publication;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import java.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "publications")
@DiscriminatorColumn(name = "Publication_type")
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

    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    //private LocalDate publicationDate;
    private LocalDate publicationDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @JsonManagedReference( value="publication_copy")
    @OneToMany(mappedBy = "publication")
    private List<Copy> copies;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getIdentificationNb() {
        return identificationNb;
    }

    public void setIdentificationNb(String identificationNb) {
        this.identificationNb = identificationNb;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNbOfAvailableCopies() {
        return nbOfAvailableCopies;
    }

    public void setNbOfAvailableCopies(int nbOfAvailableCopies) {
        this.nbOfAvailableCopies = nbOfAvailableCopies;
    }

    public int getNbTotalOfcopies() {
        return nbTotalOfcopies;
    }

    public void setNbTotalOfcopies(int nbTotalOfcopies) {
        this.nbTotalOfcopies = nbTotalOfcopies;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }
}
