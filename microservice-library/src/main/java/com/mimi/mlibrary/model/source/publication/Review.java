package com.mimi.mlibrary.model.source.publication;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("Review")
public class Review extends Publication implements Serializable {

    private String releaseDate;
    private String name;

    @JsonManagedReference( value="review_copy")
    @OneToMany(mappedBy = "review")
    private List<Copy> copies;

    public Review() {
        super();
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }
}
