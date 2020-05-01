package com.mimi.mlibrary.model.entity.publication;

public enum Category {

    BOOK("Books","Livres"),
    REVIEW("Reviews", "Revues"),
    NEWSPAPER("Newspapers", "Journaux");

    public final String enName;
    public final String frName;

    Category( String enName, String frName ) {
        this.enName = enName;
        this.frName = frName;
    }
}
