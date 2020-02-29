package com.mimi.mlibrary.model.source.publication;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Publication_type")
public abstract class Publication implements Serializable {

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
    private int nbOfAvailableCopies;
    private int nbTotalOfcopies;

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

}
