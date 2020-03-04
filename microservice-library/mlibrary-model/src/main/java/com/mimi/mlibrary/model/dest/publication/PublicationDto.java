package com.mimi.mlibrary.model.dest.publication;

import com.mimi.mlibrary.model.source.publication.Category;
import com.mimi.mlibrary.model.source.publication.Copy;
import org.joda.time.LocalDate;

import java.util.List;

public class PublicationDto {

    private Integer id;
    private int nbOfAvailableCopies;
    private int nbTotalOfcopies;
    private List<Copy> copies;
    private String title;
    private String identificationNb;
    private LocalDate publicationDate;
    private Category category;


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

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
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
}
