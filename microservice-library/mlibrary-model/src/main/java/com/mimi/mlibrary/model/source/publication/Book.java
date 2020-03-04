package com.mimi.mlibrary.model.source.publication;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Book")
public class Book extends Publication implements Serializable {

    @ManyToOne
    @JsonBackReference(value="book_editor")
    @JoinColumn(name = "edithor_fk")
    private Editor editor;

    @JsonBackReference(value="book_author")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_fk")
    private Author author;

    public Book() {
        super();
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


}
