package com.mimi.mlibrary.model.dest.publication;

public class PublicationDto {

    private int nbOfAvailableCopies;
    private int nbTotalOfcopies;
    //private List<Copy> copies;
    public PublicationDto() {
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
