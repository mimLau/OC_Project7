package com.mimi.mlibrary.model.entity.publication;

public enum SubCategory {
    NOVEL("Novel", "Roman"),
    THEATER("Theater", "Théatre"),
    POETRY("Poetry", "Poème"),
    YOUTH("Youth", "Jeunesse"),
    SCIENTIST("Scientist", "Scientifique"),
    COOKING("Cooking", "Cuisine"),
    NEWS("News", "Journal"),
    LITERARY("Litterary", "Litérature"),
    NATIONAL("National", "National"),
    REGIONAL("Regional", "Régional");

    private String frName;
    private String enName;

    SubCategory( String enName, String frName ) {
        this.enName = enName;
        this.frName = frName;
    }

    public  String getFrName() {
        return frName;
    }
}
