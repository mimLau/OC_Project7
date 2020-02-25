package com.mimi.mlibrary.model.dest.publication;

import com.mimi.mlibrary.model.source.publication.Copy;
import com.mimi.mlibrary.model.source.publication.Publication;

import java.util.List;

public class PublicationDto {

    private Integer id;
    private int nbOfAvailableCopies;
    private int nbTotalOfcopies;


    public PublicationDto() {
    }

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
