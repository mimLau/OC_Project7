package com.mimi.mlibrary.model.works;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="works")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Work_type")
public abstract class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int nbOfAvailableCopies;
    private int nbTotalOfcopies;

    @Type(type = "numeric_boolean")
    private boolean borrowable;

    @OneToMany(mappedBy = "work")
    private List<Copy> copies;

    public Integer getId() {
        return id;
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

    public boolean isBorrowable() {
        return borrowable;
    }

    public void setBorrowable(boolean borrowable) {
        this.borrowable = borrowable;
    }
}
