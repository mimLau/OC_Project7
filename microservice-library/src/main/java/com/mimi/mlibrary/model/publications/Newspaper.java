package com.mimi.mlibrary.model.publications;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Newspaper")
public class Newspaper extends Publication implements Serializable {

    private String releaseDate;
    private String name;

    public Newspaper() {
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
}
