package org.mimi.clibrary.Beans.publication;


import java.time.LocalDate;

import java.util.List;

public abstract class PublicationBean {

    private int id;
    private String title;
    private String identificationNb;
    private int nbOfAvailableCopies;
    private int nbTotalOfcopies;
    private LocalDate publicationDate;
    private CategoryBean category;
    private List<CopyBean> copies;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdentificationNb() {
        return identificationNb;
    }

    public void setIdentificationNb(String identificationNb) {
        this.identificationNb = identificationNb;
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

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public CategoryBean getCategory() {
        return category;
    }

    public void setCategory(CategoryBean category) {
        this.category = category;
    }

    public List<CopyBean> getCopies() {
        return copies;
    }

    public void setCopies(List<CopyBean> copies) {
        this.copies = copies;
    }
}
