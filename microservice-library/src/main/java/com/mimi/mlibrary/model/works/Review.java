package com.mimi.mlibrary.model.works;

public class Review extends Work {

    private String releaseDate;
    private String name;

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
}
